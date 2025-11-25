package com.spring_rest_api.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.spring_rest_api.entities")       // ✔ Entities burada
@EnableJpaRepositories(basePackages = "com.spring_rest_api.repository") // ✔ Repository burada
@ComponentScan(basePackages = "com.spring_rest_api")
public class SpringCoreApplication {
    public static void main(String[] args) {
    SpringApplication.run(SpringCoreApplication.class, args);
    }
}
