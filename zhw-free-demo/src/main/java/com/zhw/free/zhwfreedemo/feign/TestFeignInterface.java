package com.zhw.free.zhwfreedemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zhw-free-client", url = "http://localhost:8080")
public interface TestFeignInterface {



    @GetMapping("/test/{id}")
    String get(@PathVariable("id") String id);
}
