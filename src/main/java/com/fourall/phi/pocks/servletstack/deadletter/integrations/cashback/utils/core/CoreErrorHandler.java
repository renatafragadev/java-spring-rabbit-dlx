package com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ErrorHandler;

@Slf4j
public class CoreErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        log.error("Invalid message. Cause - {}. Forwarding to the exchange of dead letters", t.getCause().getMessage());
    }
}
