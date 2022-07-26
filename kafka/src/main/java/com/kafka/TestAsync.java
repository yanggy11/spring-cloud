package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author yang
 * @Date 2022/7/25 16:29
 * @ClassName TestAsync
 * @Version 1.0
 */
public class TestAsync {
    public static void main(String[] args) {
        //1、创建卡夫卡生产者对象
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "101.35.46.92:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        //关联自定义区分器
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "com.kafka.partitioner.Customepartitioner");

        properties.put(ProducerConfig.LINGER_MS_CONFIG, 5);

        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384 * 2);
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432 * 2);

        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG,"snappy");
        properties.put(ProducerConfig.ACKS_CONFIG, "1");

        //默认int表示的最大值。
        properties.put(ProducerConfig.RETRIES_CONFIG, 3);

        KafkaProducer<String, String> producer = null;

        try{
            producer = new KafkaProducer<>(properties);

            //异步发送数据
            for (int i = 0; i < 5; i++) {
                //异步发送
                producer.send(new ProducerRecord<>("test", "test" + i), ((metadata, exception) -> {
                    if(null != exception) {
                        exception.printStackTrace();
                        return;
                    }

                    System.out.println("主题:" + metadata.topic() + " 分区:" + metadata.partition());
                }));

//                producer.send(new ProducerRecord<>("canal_test", "同步发送" + i)).get();

                TimeUnit.SECONDS.sleep(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭生产者
            if(null != producer) {
                producer.close();
            }
        }
    }
}
