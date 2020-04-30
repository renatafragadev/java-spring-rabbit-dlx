package com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core;

import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.components.CoreBodyConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;


@Slf4j
@RequiredArgsConstructor
public abstract class AbstractConsumer<T> {

    protected final IMessageValidator validator;

    protected final CoreBodyConverter<T> bodyConverter;

    public abstract void receive(Message message);
}

