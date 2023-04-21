package com.example.demo;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@RequestMapping("/hello")
//@MyComponent  이것과 동일하게 것이 바로 @Controller 이다 이녀석 코드를 보면 메타 에노테이션이 되어있다.
@RestController
public class HelloController {

    // 주입하는 과정
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    //@ResponseBody //디스패쳐 서블릿은 Return 타입이 String이면 뷰를 우선적으로 찾느다.
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
