package com.example.demo;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
    public static void run(Class<?> applicationClass, String[] args) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
				DispatcherServlet dispatcherServlet=this.getBean(DispatcherServlet.class);
				
				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServelt",
					dispatcherServlet).addMapping("/*"); // 모든 요청을 처리하겠다.

				});
				webServer.start();
			}

		};
		applicationContext.register(applicationClass);  //여기서 출발을 해서 빈 오브젝틀 만들어줘
		applicationContext.refresh(); // 컨테이너를 초기화 해주는 작업
	}
}
