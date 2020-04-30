package com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core;

import org.springframework.amqp.core.Message;

public interface IMessageValidator {

    void checkMessage(Message message);

}
