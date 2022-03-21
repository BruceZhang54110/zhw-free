package com.zhw.free.zhwfreedemo.consumer.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaTestConsumer {

    @KafkaListener(topics = "TestComposeTopic", groupId = "test1")
    public void consumerTopic(String msg) {
        log.info("consumerTopic---0--- kafka consumer :" + msg);
    }

    @KafkaListener(topics = "TestComposeTopic", groupId = "test1")
    public void consumerTopic1(String msg) {
        log.info("consumerTopic1---1--- kafka consumer :" + msg);
    }

    @KafkaListener(topics = "TestComposeTopic", groupId = "test1")
    public void consumerTopic2(String msg) {
        log.info("consumerTopic1---2--- kafka consumer :" + msg);
    }

    @KafkaListener(topics = "TestComposeTopic", groupId = "test1")
    public void consumerTopic3(String msg) {
        log.info("consumerTopic1---3--- kafka consumer :" + msg);
    }
}
