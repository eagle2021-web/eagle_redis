package com.eagle.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ServiceSmsApplication {
    //http://localhost:8120/swagger-ui.html 打开swagger
    public static void main(String[] args) {
        SpringApplication.run(ServiceSmsApplication.class, args);
    }
}