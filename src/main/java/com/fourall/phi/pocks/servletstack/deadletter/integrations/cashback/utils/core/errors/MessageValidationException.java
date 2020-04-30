package com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.errors;

public class MessageValidationException extends RuntimeException {

    public MessageValidationException(String message) {
        super(message);
    }
}
