package com.yanggy.order.feign;

import feign.Request;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author yanggy
 */
@FeignClient(name = "user-center", configuration = {UserCenterFeign.UserCenterConfiguration.class}, fallbackFactory = UserCenterFeign.UserCenterFallbackFactory.class)
public interface UserCenterFeign {
    /**
     * test 方法
     * @return String
     */
    @GetMapping("/test")
    String test();

    @Component
    @Log4j2
    class UserCenterFallbackFactory implements FallbackFactory<UserCenterFallback> {

        @Override
        public UserCenterFallback create(Throwable cause) {
            log.error("[UserCenterFeign.test] fallback", cause);
            return new UserCenterFallback();
        }
    }
    class UserCenterFallback implements UserCenterFeign{

        @Override
        public String test() {
            return "echo fallback!";
        }
    }

    @Configuration
    class UserCenterConfiguration {
        @Bean
        public Request.Options options() {
            return new Request.Options(500, TimeUnit.MILLISECONDS, 1500, TimeUnit.MILLISECONDS, true);
        }
    }
}
