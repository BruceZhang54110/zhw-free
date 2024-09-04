package com.zhw.free.zhwfreedemo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "stomp-broker")
@Configuration
@Data
public class StompBrokerProperties {

    private String relayHost = "127.0.0.1";

    private int relayPort = 61613;

    private String clientLogin = "guest";

    private String clientPasscode = "guest";

    private String systemLogin = "guest";

    private String systemPasscode = "guest";

    private Long systemHeartbeatSendInterval;

    private Long systemHeartbeatReceiveInterval;

    private String virtualHost;
}
