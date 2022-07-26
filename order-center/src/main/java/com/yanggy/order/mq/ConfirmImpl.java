package com.yanggy.order.mq;


import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author yang
 * @Date 2022/7/15 18:09
 * @ClassName ConfirmImpl
 * @Version 1.0
 */
@Configuration
public class ConfirmImpl implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
        return rabbitTemplate;
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(1);
    }

    @Override
    public void returnedMessage(ReturnedMessage returned) {
        System.out.println(1);
    }
}
