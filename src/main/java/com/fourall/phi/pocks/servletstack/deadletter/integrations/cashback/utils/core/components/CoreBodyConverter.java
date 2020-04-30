package com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.enums.LogEnum;
import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.errors.MessageConverterException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CoreBodyConverter<T> {

    public T converterToPojo(byte[] body, Class<T> tClass) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(body, tClass);
        } catch (IOException e) {
            throw new MessageConverterException(LogEnum.MSG_ERROR_BODY.getValue());
        }
    }

    public byte[] converterToByteArray(T pojo) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsBytes(pojo);
        } catch (IOException e) {
            throw new MessageConverterException(LogEnum.MSG_ERROR_BODY.getValue());
        }
    }
}
