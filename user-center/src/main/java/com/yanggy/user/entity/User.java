package com.yanggy.user.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description
 * @Author yang
 * @Date 2022/6/8 16:09
 * @ClassName User
 * @Version 1.0
 */

@Data
@Accessors(chain = true)
@ToString
public class User implements Serializable {
    private Long id;
    private String name;
    private int age;
}
