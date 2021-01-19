package com.zhw.free.zhwfreedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhw.free.zhwfreedemo.mapper")
public class ZhwFreeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhwFreeDemoApplication.class, args);
    }

}
