package com.example.main;


import com.example.config.AppConfig;
import com.example.model.User;
import com.example.services.LoginService;
import com.example.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        for (User user : userService.getUserList()) {
            System.out.println("User Name: " + user);
        }
        LoginService loginService = new LoginService();
        loginService.login();
    }
}
