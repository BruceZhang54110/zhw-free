package com.zhw.free.zhwfreedemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RefreshScope
@RequestMapping("/config")
public class TestConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        return ",teststr: " + useLocalCache;
    }
}
