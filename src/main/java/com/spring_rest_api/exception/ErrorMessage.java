package com.spring_rest_api.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ErrorMessage {

    private final String code;
    private final String message;
    private final LocalDateTime timestamp;

    private String prepareMessage(String staticMessage, String dynamicMessage) {
        if (dynamicMessage == null || dynamicMessage.isBlank()) {
            return staticMessage;
        }
        return staticMessage + " : " + dynamicMessage;
    }
}
