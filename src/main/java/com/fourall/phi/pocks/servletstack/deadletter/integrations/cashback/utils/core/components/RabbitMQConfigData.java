package com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.components;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class RabbitMQConfigData {

    @Value("${spring.rabbitmq.username}")
    public String username;
}
