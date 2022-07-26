package com.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author yang
 * @Date 2022/7/23 13:33
 * @ClassName Consumer
 * @Version 1.0
 */

@Component
public class Consumer {
    @KafkaListener(topics = "canal_test", groupId = "test")
    public void listen(ConsumerRecord<String, String> record, Acknowledgment ack) {

        System.out.println("send1:" + record);

        ack.acknowledge();
    }

    @KafkaListener(topics = "canal_test", groupId = "test")
    public void listen2(ConsumerRecord<String, String> record, Acknowledgment ack) {
        System.out.println("send2:" + record);

        ack.acknowledge();
    }
}
