package com.yanggy.order.service.impl.mongo;

import com.yanggy.order.entity.mongo.OperationLog;
import com.yanggy.order.service.mongo.IMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description MongoDB操作类
 * @Author yang
 * @Date 2022/7/19 09:34
 * @ClassName MongoServiceImpl
 * @Version 1.0
 */

@Service
public class MongoServiceImpl implements IMongoService {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public int addLog(OperationLog operationLog) {
        mongoTemplate.insert(operationLog);
        return 0;
    }

    @Override
    public List<OperationLog> queryLogs(OperationLog param) {
        return mongoTemplate.query(OperationLog.class).matching(Query.query(Criteria.where("operationType").is(param.getOperationType()))).all();
    }
}
