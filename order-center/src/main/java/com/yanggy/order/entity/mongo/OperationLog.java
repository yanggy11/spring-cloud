package com.yanggy.order.entity.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 操作日志实体类
 *
 * @Description 操作日志
 * @Author yang
 * @Date 2022/7/19 09:24
 * @ClassName OperationLog
 * @Version 1.0
 */

@Data
public class OperationLog {
    @Id
    private String id;
    private String operation;
    private String operationType;
    private String system;
    private Object content;
    private Object data;
    private String operatorId;
    private String operator;
    private Date createTime;
}
