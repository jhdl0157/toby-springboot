package com.example.demo;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class HelloController {

    //주입하는 과정
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name){
        return helloService.sayHello(Objects.requireNonNull(name)); 
    }
}
