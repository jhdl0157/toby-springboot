package com.example.demo;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



@Configuration
@ComponentScan  //하위 패키지의 클래스들을 뒤져서 @Component라는 오브젝트를 스프링 컨테이너에 등록을 해준다.
public class DemoApplication {


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
