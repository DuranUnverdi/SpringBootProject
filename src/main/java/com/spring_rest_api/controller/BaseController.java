package com.spring_rest_api.controller;

import com.spring_rest_api.entities.RootEntity;

public class BaseController {

    public <T>RootEntity<T> ok(T data) {
        return RootEntity.ok(data);
    }
    public <T>RootEntity<T> error(String errorMessage) {
        return RootEntity.error(errorMessage);
    }
}
