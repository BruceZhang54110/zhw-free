package com.zhw.free.zhwfreedemo.producer;

import com.zhw.free.zhwfreedemo.eneity.TOrder;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(TOrder order) throws Exception {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());
        MessageConverter messageConverter = rabbitTemplate.getMessageConverter();
        System.out.println(messageConverter);
        rabbitTemplate.convertAndSend(
                "order-exchange",
                "order.abcd",
                order,
                correlationData);  // 消息唯一id
    }
}
