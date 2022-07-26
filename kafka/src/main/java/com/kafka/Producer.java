package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author yang
 * @Date 2022/7/23 13:31
 * @ClassName Producer
 * @Version 1.0
 */

@RestController
public class Producer {
    private static final String TOPIC_NAME = "canal_test";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public void sen() {
        kafkaTemplate.send(TOPIC_NAME, "key", "test message send");
    }
}
