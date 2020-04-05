package com.examplelocal.demo;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "hello world";
    }
}
