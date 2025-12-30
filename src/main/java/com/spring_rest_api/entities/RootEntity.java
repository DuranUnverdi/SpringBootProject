package com.spring_rest_api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RootEntity<T> {
    private boolean result;
    private String errorMessage;
    private T data;

    public static  <T> RootEntity<T> ok(T data) {

        RootEntity<T> response = new RootEntity<>();
        response.setData(data);
        response.setResult(true);
        response.setErrorMessage(null);
        return response;
    }
    public static <T> RootEntity<T> error(String errorMessage) {
        RootEntity<T> response = new RootEntity<>();
        response.setData(null);
        response.setResult(false);
        response.setErrorMessage(errorMessage);
        return response;
    }
}
