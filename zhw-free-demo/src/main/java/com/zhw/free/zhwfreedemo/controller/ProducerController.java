package com.zhw.free.zhwfreedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/data/{msg}")
    public String data(@PathVariable String msg) {
        // 通过kafka发送出去
        kafkaTemplate.send("TestComposeTopic", msg);
        return "ok";
    }
}
