package com.yanggy.order.service.mongo;

import com.yanggy.order.entity.mongo.OperationLog;

import java.util.List;

/**
 * @Description
 * @Author yang
 * @Date 2022/7/19 09:32
 * @ClassName IMongoService
 * @Version 1.0
 */
public interface IMongoService {
    /**
     * 日志入库操作
     *
     * @param operationLog 操作日志
     * @return 入库条数
     */
    int addLog(OperationLog operationLog);
    List<OperationLog> queryLogs(OperationLog param);
}
