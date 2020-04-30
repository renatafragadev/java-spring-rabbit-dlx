package com.fourall.phi.pocks.servletstack.deadletter.config;

import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.CoreErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ErrorHandler;

@RequiredArgsConstructor
@Configuration
public class RabbitMQConfig {

    private final ConnectionFactory connectionFactory;

    @Bean
    public SimpleRabbitListenerContainerFactory listenerContainer() {
        SimpleRabbitListenerContainerFactory container = new SimpleRabbitListenerContainerFactory();
        container.setConnectionFactory(connectionFactory);
        container.setDefaultRequeueRejected(false);
        container.setErrorHandler(errorHandler());
        return container;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public ErrorHandler errorHandler() {
        return new CoreErrorHandler();
    }
}

