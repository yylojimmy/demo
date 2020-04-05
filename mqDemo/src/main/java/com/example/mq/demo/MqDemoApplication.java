package com.example.mq.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Service;

@Slf4j
@SpringBootApplication
public class MqDemoApplication extends SpringBootServletInitializer {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MqDemoApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(MqDemoApplication.class);
    }
    public static void main(String[] args) {

        log.info("r---------->>>testing main");
        SpringApplication.run(MqDemoApplication.class, args);
    }


    @Service
    @RocketMQMessageListener(topic = "jimmytopic", consumerGroup = "jimmySubscriptionGroup")
    public static class MyConsumer1 implements RocketMQListener<String> {
        public void onMessage(String message) {
            log.info("received message: {}", message);
        }
    }

}
