package com.yanggy.user.utils;

import com.yanggy.user.entity.User;

/**
 * @Description
 * @Author yang
 * @Date 2022/6/17 14:25
 * @ClassName ThreadLocalUtils
 * @Version 1.0
 */
public class ThreadLocalUtils {
    public static final ThreadLocal<User> USER_LOCAL = ThreadLocal.withInitial(() -> null);
}
