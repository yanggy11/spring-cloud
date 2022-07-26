package com.yanggy.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yanggy.order.entity.mongo.OperationLog;
import com.yanggy.order.feign.UserCenterFeign;
import com.yanggy.order.mq.MqService;
import com.yanggy.order.service.TestService;
import com.yanggy.order.service.mongo.IMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestController {

    private final UserCenterFeign userCenterFeign;
    private MqService mqService;

    @Autowired
    private IMongoService mongoService;


    @Autowired
    private TestService testService;

    @GetMapping(value = "/sendMs")
    public String sendMs(@RequestBody String msg) {
        mqService.send(msg);
        return "success";
    }

    @PostMapping(value = "recognizeInspection",produces = "application/json;charset=UTF-8")
    public Object recognizeInspection(@RequestParam(value = "invoiceFile", required = false) MultipartFile invoiceFile, @RequestParam(required = false) Map<String, Object> inspectionParam) {

        System.out.println(inspectionParam);
        return new HashMap<>();
    }

    @SentinelResource(value = "/test")
    @PostMapping("/test")
    public String test(String a) {
        System.out.println("---before set method" + testService);
        System.out.println(testService.setName(a));
        System.out.println("---after set method" + testService);
        System.out.println(testService.getName());
        System.out.println("---end test method" + testService);

        return "test";
    }

    @SentinelResource(value = "/test1")
    @GetMapping("/test1")
    public String test1() {
        return "success";
    }

    @Autowired
    public TestController(UserCenterFeign userCenterFeign, MqService mqService) {
        this.userCenterFeign = userCenterFeign;
        this.mqService = mqService;
    }

    @PostMapping(value = "/addLog")
    public String testMongo(@RequestBody OperationLog operationLog) {
        operationLog.setCreateTime(new Date());
        mongoService.addLog(operationLog);

        return "success";
    }

    @PostMapping(value = "/queryLogs")
    public List<OperationLog> queryLogs(@RequestBody OperationLog operationLog) {
        return mongoService.queryLogs(operationLog);
    }
}