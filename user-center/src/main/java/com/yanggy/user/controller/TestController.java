package com.yanggy.user.controller;

import com.yanggy.user.service.mq.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
@RestController
public class TestController {

    @Autowired
    private MqService mqService;

    @Value("${server.test}")
    private String test;

    @GetMapping("/test")
    public String test() {

        return test;
    }

    @GetMapping("/mq")
    public String send() {
        mqService.send();

        return "success";
    }


}