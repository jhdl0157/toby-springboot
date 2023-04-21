package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



@Configuration
@ComponentScan  //하위 패키지의 클래스들을 뒤져서 @Component라는 오브젝트를 스프링 컨테이너에 등록을 해준다.
public class DemoApplication {

	@Bean
	public ServletWebServerFactory servletWebServerFactory(){
		return new TomcatServletWebServerFactory();
	}

	@Bean
	public DispatcherServlet dispatcherServelt(){
		//applicationContext를 어떻게 전달을 받을까??
		return new DispatcherServlet();
	}


	public static void main(String[] args) {
		// 스프링 컨테이너 만들기
		 SpringApplication.run(DemoApplication.class, args);  //우리가 아무생각 없이 보던 스프링 초기 코드 완성 

	}
}
