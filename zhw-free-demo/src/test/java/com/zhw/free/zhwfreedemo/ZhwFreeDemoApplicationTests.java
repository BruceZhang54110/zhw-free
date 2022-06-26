package com.zhw.free.zhwfreedemo;

import com.zhw.free.zhwfreedemo.eneity.TOrder;
// import com.zhw.free.zhwfreedemo.producer.OrderSender;
import com.zhw.free.zhwfreedemo.feign.TestFeignInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@Slf4j
@SpringBootTest
class ZhwFreeDemoApplicationTests {

    //@Autowired
    //private OrderSender orderSender;

    @Autowired
    TestFeignInterface testFeignInterface;

    @Test
    public void testSend1() throws  Exception {
        TOrder order = new TOrder();
        order.setId(1232222);
        order.setName("test1");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        //orderSender.sendOrder(order);
    }


    @Test
    public void test2() {
        log.info(testFeignInterface.get("ddd"));
    }

}
