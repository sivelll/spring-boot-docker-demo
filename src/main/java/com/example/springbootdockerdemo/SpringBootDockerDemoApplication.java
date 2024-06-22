package com.example.springbootdockerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class SpringBootDockerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerDemoApplication.class, args);
    }

}
