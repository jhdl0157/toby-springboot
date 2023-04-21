package com.example.demo;

import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class DemoApplication {
	//Factory 메서드를 통해서 빈 오브젝트를 만든다.
	@Bean
	public HelloController helloController(HelloService helloService){
		return new HelloController(helloService);
	}
	@Bean
	public HelloService helloService(){
		return new SimpleHelloService();
	}

	public static void main(String[] args) {
		// 스프링 컨테이너 만들기
		 AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServelt",
							new DispatcherServlet(this)).addMapping("/*"); // 모든 요청을 처리하겠다.

				});
				webServer.start();
			}

		};
		applicationContext.register(DemoApplication.class);  //여기서 출발을 해서 빈 오브젝틀 만들어줘
		applicationContext.refresh(); // 컨테이너를 초기화 해주는 작업

	}

}
