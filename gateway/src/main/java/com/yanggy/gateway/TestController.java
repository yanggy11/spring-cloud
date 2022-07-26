package com.yanggy.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author yang
 * @Date 2022/7/22 16:58
 * @ClassName TestController
 * @Version 1.0
 */

@RestController
public class TestController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping("/test")
    public String testKafka(@RequestBody String data) {
        kafkaTemplate.send("canal_test", data);

        return "success";
    }
}
