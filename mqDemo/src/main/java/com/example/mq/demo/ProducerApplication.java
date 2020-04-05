package com.example.mq.demo;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

//@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {
    @Resource
    private RocketMQTemplate rocketMQTemplate;



    public static void main(String[] args){
        SpringApplication.run(ProducerApplication.class, args);
    }

    public void run(String... args) throws Exception {
        rocketMQTemplate.convertAndSend("jimmytopic", "Hello, World! from springboot");
        rocketMQTemplate.send("jimmytopic", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
    }

}
