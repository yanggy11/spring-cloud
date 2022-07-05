package com.yanggy.order.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanggy
 * @date 2022/5/5 10:29
 * @type class
 * @description 订单 api
 */
@RestController("/order")
public class OrderController {
    @PostMapping("/addOrder")
    public String addOrder() {
        return "order added";
    }
}
