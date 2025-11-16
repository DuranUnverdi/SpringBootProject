package com.spring_rest_api.config;

import com.spring_rest_api.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<Employee> getEmployees() {

        return new ArrayList<>( List.of(
                new Employee("1", "John", "Doe"),
                new Employee("2", "Jane", "Smith"),
                new Employee("3", "Alice", "Johnson"),
                new Employee("4", "Duran", "Ünverdi"),
                new Employee("5", "Marln", "Trester"),
                new Employee("6", "Kelly", "Clarkson")));
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF devre dışı
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Tüm endpoint'lere izin

        return http.build();
    }

}
