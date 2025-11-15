package com.example.services;

import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoginService {
    public void login() {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService= context.getBean(UserService.class);

    }
}
