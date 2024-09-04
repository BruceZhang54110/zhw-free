package com.zhw.free.zhwfreedemo.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.config.StompBrokerRelayRegistration;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * websocket config
 * extends AbstractSessionWebSocketMessageBrokerConfigurer<Session>
 * implements WebSocketMessageBrokerConfigurer
 */
@Slf4j
//@EnableConfigurationProperties({StompBrokerProperties.class})
//@EnableWebSocketMessageBroker
//@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Resource
    private StompBrokerProperties stompBrokerProperties;
    /**
     *
     *  注册websocket-stomp 服务地址
     *  @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("websocket")
                .setAllowedOriginPatterns("*");
    }



    /**
     * 配置订阅接口地址
     * @param messageBrokerRegistry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        log.info("WebSocketMessageBrokerConfigurer configureMessageBroker init start");
        // 客户端发送时地址前缀
        messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
        // 客户端订阅服务的地址前缀
        // 指定目标用啥发送时，客户端订阅服务前缀
        messageBrokerRegistry.setUserDestinationPrefix("/user");
        StompBrokerRelayRegistration stompBrokerRelayRegistration = null;
        stompBrokerRelayRegistration = messageBrokerRegistry.enableStompBrokerRelay("/topic");
        if (stompBrokerRelayRegistration != null) {
            stompBrokerRelayRegistration.setAutoStartup(true)
                    .setRelayHost(stompBrokerProperties.getRelayHost())
                    .setRelayPort(stompBrokerProperties.getRelayPort())
                    .setClientLogin(stompBrokerProperties.getClientLogin())
                    .setClientPasscode(stompBrokerProperties.getClientPasscode())
                    .setSystemLogin(stompBrokerProperties.getSystemLogin())
                    .setSystemPasscode(stompBrokerProperties.getSystemPasscode())
                    .setVirtualHost(stompBrokerProperties.getVirtualHost())
                    .setSystemHeartbeatReceiveInterval(stompBrokerProperties.getSystemHeartbeatReceiveInterval())
                    .setSystemHeartbeatSendInterval(stompBrokerProperties.getSystemHeartbeatSendInterval());
            log.info("enableStompBrokerRelay init success");
        }

    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(myChannelInterceptor());
    }

    /**
     * 鉴权拦截器
     * @return
     */
    private ChannelInterceptor myChannelInterceptor() {
        return new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                if (accessor != null) {
                    StompCommand command = accessor.getCommand();
                    if (StompCommand.CONNECT.equals(command)) {
                        log.info("CONNECT accessor: {}", accessor);
                        // accessor.setUser(new UserInfo(wsToken));
                    }
                }
                return message;
            }
        };
    }


    @AllArgsConstructor
    @Data
    class UserInfo implements Principal {


        private String wsToken;

        /**
         * Returns the name of this principal.
         *
         * @return the name of this principal.
         */
        @Override
        public String getName() {
            return wsToken;
        }
    }

}
