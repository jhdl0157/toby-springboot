package com.example.demo;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
public class HelloController {

    // 주입하는 과정
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody //디스패쳐 서블릿은 Return 타입이 String이면 뷰를 우선적으로 찾느다.
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
