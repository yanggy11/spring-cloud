package com.yanggy.user.service.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author yang
 * @Date 2022/6/23 11:07
 * @ClassName Consumer
 * @Version 1.0
 */

@Component
public class Consumer {
    @RabbitListener(bindings = @QueueBinding(value = @Queue("myqueue"),exchange = @Exchange("myexchanage")))
    public void consume(Message message) {
        System.out.println(new String(message.getBody()));
    }
}
