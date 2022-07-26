package com.yanggy.order.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yang
 * @Date 2022/7/6 17:46
 * @ClassName TestService
 * @Version 1.0
 */
@Service
@Scope(scopeName = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TestService {

    private String name = "hhh";
    public void test() {
        System.out.println(this.name);
        System.out.println("test");
    }

    public String setName(String name) {
        this.name = name;

        return this.name;
    }


    public String getName() {
        return name.toString();
    }
}
