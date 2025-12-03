package com.spring_rest_api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    private List<String> errorMessages(List<String> list, String message) {
        list.add(message);
        return list;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errors = new HashMap<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
            if (errors.containsKey(fieldName)) {
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessages(errors.get(fieldName), errorMessage));
                continue;
            } else {
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessages(new java.util.ArrayList<>(), errorMessage));
            }

        }
        return ResponseEntity.badRequest().body(createApiError(errors));
    }

    private <T> ApiError<T> createApiError(T errors) {
        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(java.util.UUID.randomUUID().toString());
        apiError.setErrorDate(new java.util.Date());
        apiError.setErrors(errors);
        return apiError;
    }

}
