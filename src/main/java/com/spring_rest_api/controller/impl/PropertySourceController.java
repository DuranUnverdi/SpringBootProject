package com.spring_rest_api.controller.impl;

import com.spring_rest_api.configuration.DataSource;
import com.spring_rest_api.configuration.GlobalProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/properties")
@RequiredArgsConstructor
public class PropertySourceController {

    private final GlobalProperties globalProperties;
    @GetMapping("/datasource")
    public DataSource getDataSource(){
        DataSource dataSource=new DataSource();
        dataSource.setUrl(globalProperties.getUrl());
        dataSource.setUsername(globalProperties.getUsername());
        dataSource.setPassword(globalProperties.getPassword());
        return dataSource;
    }
}
