package com.zhw.free.zhwfreedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients("com.zhw.free.zhwfreedemo.feign")
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.zhw.free.zhwfreedemo.mapper")
public class ZhwFreeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhwFreeDemoApplication.class, args);

    }

}
