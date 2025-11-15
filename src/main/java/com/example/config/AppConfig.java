package com.example.config;

import com.example.model.User;
import com.example.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public UserService userServiceConfig() {
        // Configuration code for UserService
        UserService userService = new UserService();
        List<User> userList = new ArrayList<>();
        userList.add(new User("Duran"));
        userList.add(new User("Aliye"));
        userService.setUserList(userList);
        return userService;
    }
}
