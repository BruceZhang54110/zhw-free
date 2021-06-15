package com.zhw.free.zhwfreedemo;

import com.zhw.free.zhwfreedemo.eneity.TOrder;
// import com.zhw.free.zhwfreedemo.producer.OrderSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ZhwFreeDemoApplicationTests {

    //@Autowired
    //private OrderSender orderSender;

    @Test
    public void testSend1() throws  Exception {
        TOrder order = new TOrder();
        order.setId(1232222);
        order.setName("test1");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        //orderSender.sendOrder(order);
    }

}
