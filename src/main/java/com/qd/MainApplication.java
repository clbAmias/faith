package com.qd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApplication.class, args);

        System.out.println("-----applicationName:" + applicationContext.getApplicationName());
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        System.out.println("-----server.port:" + environment.getProperty("server.port"));
        System.out.println("-----server.context-path:" + environment.getProperty("server.context-path"));


        System.out.println(1);


    }
}
