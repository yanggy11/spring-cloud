package com.yanggy.order.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
    public void consume(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        System.out.println("consume:" + new String(message.getBody()));

    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("myqueue"),exchange = @Exchange("myexchanage")))
    public void consume1(Message message, Channel channel) throws IOException {

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("consume1:" + new String(message.getBody()));
        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,true);
    }
}
