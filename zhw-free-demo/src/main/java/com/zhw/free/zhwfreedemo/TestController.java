package com.zhw.free.zhwfreedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class TestController {

    @Autowired
    RedisTemplate redisTemplate;


    @RequestMapping("test")
    public String test() {
        redisTemplate.opsForValue().set("testaaa", "test zhw");
        log.info((String) redisTemplate.opsForValue().get("testaaa"));
        return "success";
    }
}
