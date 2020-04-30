package com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.components;

import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.pojo.CashBackPojo;
import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.components.MessageConverter;
import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.AbstractConsumer;
import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.components.CoreBodyConverter;
import com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.IMessageValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CashBackConsumer extends AbstractConsumer<CashBackPojo> {

    private final RabbitTemplate rabbitTemplate;


    public CashBackConsumer(IMessageValidator validator, CoreBodyConverter<CashBackPojo> bodyConverter,
                            RabbitTemplate rabbitTemplate) {
        super(validator, bodyConverter);
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "cashback-service.cashback.search", containerFactory = "listenerContainer")
    @Override
    public void receive(Message message) {
        validator.checkMessage(message);

        CashBackPojo cashBackPojo = bodyConverter.converterToPojo(message.getBody(), CashBackPojo.class);
        log.info("CashBack Sucesso - {}", cashBackPojo);

        rabbitTemplate.send("cashback.fx", "", MessageConverter.converter(bodyConverter
                .converterToByteArray(cashBackPojo)));
    }


}
