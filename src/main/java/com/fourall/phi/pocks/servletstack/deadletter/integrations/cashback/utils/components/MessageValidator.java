package com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.components;

import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.enums.LogEnum;
import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.IMessageValidator;
import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.errors.MessageValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class MessageValidator implements IMessageValidator {

    @Override
    public void checkMessage(Message message) {
        checkProperties(message.getMessageProperties());
    }

    private void checkProperties(MessageProperties properties) {
        if (!MessageProperties.CONTENT_TYPE_JSON.equals(properties.getContentType())) {
            throw new MessageValidationException(LogEnum.MSG_ERROR_CONTENT_TYPE.getValue());

        } else if (Optional.ofNullable(properties.getMessageId()).isEmpty()) {
            throw new MessageValidationException(LogEnum.MSG_ERROR_MESSAGE_ID.getValue());

        } else if (Optional.ofNullable(properties.getTimestamp()).isEmpty()) {
            throw new MessageValidationException(LogEnum.MSG_ERROR_TIMESTAMP.getValue());
        }
    }
}