package com.spring_rest_api.handler;

import com.spring_rest_api.exception.ApiError;
import com.spring_rest_api.exception.BaseException;
import com.spring_rest_api.exception.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ApiError> handleException(BaseException exception, WebRequest request) {

        return ResponseEntity.badRequest().body(createApiError(exception.getMessage(),request));
    }
    private String getHostName() {
        try {
            return java.net.InetAddress.getLocalHost().getHostName();
        } catch (java.net.UnknownHostException e) {
            return "Unknown Host";
        }
    }
    public <E> ApiError<E> createApiError(E message,WebRequest request) {
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        Exception<E> exception = new Exception<>();
        exception.setCreateTime(new java.util.Date());
        exception.setHostName(getHostName());
        exception.setPath(request.getDescription(false));
        exception.setMessage(message);

        apiError.setException(exception);
        return apiError;
    }
}
