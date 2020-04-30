package com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.components;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;

import java.util.Date;
import java.util.UUID;

public class MessageConverter {

    public static Message converter(byte[] body) {
        return MessageBuilder.withBody(body).andProperties(defaultProperties()).build();
    }

    public static MessageProperties defaultProperties() {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setMessageId(UUID.randomUUID().toString());
        messageProperties.setTimestamp(new Date());
        return messageProperties;
    }
}
