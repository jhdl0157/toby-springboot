package com.example.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component //굳이 더 해야하나?? 하지만 계층형 아키텍츠를 만들때 구분 할수 있는 것이 가능하다.
public @interface MyComponent {  //메타에노테이션 이것이 
    
}
