package com.spring_rest_api.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.spring_rest_api"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringCoreApplication {
    public static void main(String[] args) {
    SpringApplication.run(SpringCoreApplication.class, args);
    }
}
