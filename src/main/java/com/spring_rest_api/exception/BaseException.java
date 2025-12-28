package com.spring_rest_api.exception;

import lombok.Getter;


    @Getter
    public class BaseException extends RuntimeException {

        private final MessageType messageType;
        private final String dynamicMessage;

        public BaseException(MessageType messageType, String dynamicMessage) {
            super(messageType.getMessage());
            this.messageType = messageType;
            this.dynamicMessage = dynamicMessage;
        }

        public BaseException(MessageType messageType) {
            this(messageType, null);
        }

}
