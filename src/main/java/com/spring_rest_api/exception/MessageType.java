package com.spring_rest_api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

    @Getter
    public enum MessageType {

        NO_RECORD_EXIST("ERR001", "Kayıt bulunamadı", HttpStatus.NOT_FOUND),
        GENERAL_EXCEPTION("ERR002", "Genel hata oluştu", HttpStatus.INTERNAL_SERVER_ERROR);

        private final String code;
        private final String message;
        private final HttpStatus httpStatus;

        MessageType(String code, String message, HttpStatus httpStatus) {
            this.code = code;
            this.message = message;
            this.httpStatus = httpStatus;
        }


}
