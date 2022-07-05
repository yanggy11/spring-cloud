package com.yanggy.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yanggy.order.feign.UserCenterFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final UserCenterFeign userCenterFeign;

    @SentinelResource(value = "/test")
    @PostMapping("/test")
    public String test(String a) {
        return userCenterFeign.test();
    }

    @SentinelResource(value = "/test1")
    @GetMapping("/test1")
    public String test1() {
        return "success";
    }

    @Autowired
    public TestController(UserCenterFeign userCenterFeign) {
        this.userCenterFeign = userCenterFeign;
    }
}