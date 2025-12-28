//package com.spring_rest_api.exception;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//
//import java.util.*;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    private List<String> errorMessages(List<String> list, String message) {
//        list.add(message);
//        return list;
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        Map<String, List<String>> errors = new HashMap<>();
//
//        ex.getBindingResult().getAllErrors().forEach(error -> {
//            String fieldName = ((org.springframework.validation.FieldError) error).getField();
//            errors.computeIfAbsent(fieldName, k -> new ArrayList<>())
//                    .add(error.getDefaultMessage());
//        });
//
//        return ResponseEntity.badRequest().body(createApiError(errors));
//    }
//
//    @ExceptionHandler(BaseException.class)
//    public ResponseEntity<ApiError<String>> handleEmployeeNotFoundException(BaseException ex) {
//
//        ApiError<String> apiError = new ApiError<>();
//        apiError.setId(UUID.randomUUID().toString());
//        apiError.setErrorDate(new Date());
//        apiError.setErrors(ex.getMessage());
//
//        return ResponseEntity.status(404).body(apiError);
//    }
//
//    private <T> ApiError<T> createApiError(T errors) {
//        ApiError<T> apiError = new ApiError<>();
//        apiError.setId(UUID.randomUUID().toString());
//        apiError.setErrorDate(new Date());
//        apiError.setErrors(errors);
//        return apiError;
//    }
//}
