package com.yanggy.user;

import com.yanggy.user.entity.User;
import com.yanggy.user.utils.ThreadLocalUtils;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * @Description
 * @Author yang
 * @Date 2022/6/17 14:29
 * @ClassName UserHandler
 * @Version 1.0
 */

@Component
public class UserHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = new User();
        Object o = new Object();
        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        user.setId(Thread.currentThread().getId());
        user.setName(Thread.currentThread().getName());

        user.setAge(new Random().nextInt(100));
        ThreadLocalUtils.USER_LOCAL.set(user);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
