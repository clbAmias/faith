package com.qd.controller.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(HelloApplication.class, args);

		System.out.println("-----applicationName:"+applicationContext.getApplicationName());
		ConfigurableEnvironment environment = applicationContext.getEnvironment();

		System.out.println(	"-----server.port:"	+environment.getProperty("server.port"));
		System.out.println("-----server.context-path:"+environment.getProperty("server.context-path"));
	}
}
