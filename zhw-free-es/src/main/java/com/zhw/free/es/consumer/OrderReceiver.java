package com.zhw.free.es.consumer;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.rabbitmq.client.Channel;
import com.zhw.free.es.edtity.TOrder;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class OrderReceiver {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue", durable = "true"),
            exchange = @Exchange(name = "order-exchange" ,durable = "true", type = "topic"),
            key = "order.*"
    ))
    @RabbitHandler
    public void onOrderMessage(@Payload TOrder order, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        // 消费者操作
        System.out.println("----------收到消息，开始消费-----------");
        System.out.println("订单ID: " + order.getId());
        // 确认签收
        Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        // deliveryTag  该消息的index
        // false : 是否批量,将一次性ack所有小于deliveryTag的消息。
        // channel.basicAck(deliveryTag, false);
        System.out.println("----------ack，finished-----------");

    }
}
