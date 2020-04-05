package com.example.mq.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class MqController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    @GetMapping("/hello")
    String hello(){

        return "hello world";
    }

    @GetMapping("/sendMqMsg")
    String sendMqMsg(){

        rocketMQTemplate.convertAndSend("jimmytopic", "Hello, World! from springboot");
        rocketMQTemplate.send("jimmytopic", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
        return "msg sent";
    }
}
