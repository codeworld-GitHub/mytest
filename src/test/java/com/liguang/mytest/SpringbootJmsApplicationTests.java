package com.liguang.mytest;

import com.liguang.mytest.activemq.Constant;
import com.liguang.mytest.activemq.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jms.Destination;

@SpringBootTest
public class SpringbootJmsApplicationTests {
    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() throws InterruptedException {
        Destination destination = new ActiveMQQueue(Constant.MQ);

        for (int i = 0; i < 100; i++) {
            producer.sendMessage(destination, "myname is chhliu!!!");
        }
    }
}
