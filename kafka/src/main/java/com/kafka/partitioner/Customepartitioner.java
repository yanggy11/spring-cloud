package com.kafka.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @Description
 * @Author yang
 * @Date 2022/7/26 08:33
 * @ClassName Customepartitioner
 * @Version 1.0
 */
public class Customepartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        //获取数据
        String msg = value.toString();
        int partition = 0;
        if(!msg.contains("atguigu")) {
            partition = 1;
        }

        return partition;
    }

    @Override
    public void close() {
    }

    @Override
    public void configure(Map<String, ?> configs) {
    }
}
