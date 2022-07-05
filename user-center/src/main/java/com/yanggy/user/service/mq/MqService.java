package com.yanggy.user.service.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yang
 * @Date 2022/6/23 11:03
 * @ClassName MqService
 * @Version 1.0
 */

@Service
public class MqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend("myqueue", "hello");
    }
}
