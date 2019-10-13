package com.zouls.coordinate_kafka;

import org.apache.kafka.clients.consumer.CommitFailedException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class MyConsumer {

    private static KafkaConsumer<String, String> consumer;
    private static Properties properties;

    static {

        properties = new Properties();

        properties.put("bootstrap.servers", "127.0.0.1:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "KafkaStudy");
    }

    /**
     * 自动提交
     */
    private static void generalConsumeMessageAutoCommit() {

        properties.put("enable.auto.commit", true);//每隔5秒自动提交
        consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singleton("imooc-kafka-study-x"));

        try {
            while (true) {

                boolean flag = true;
                ConsumerRecords<String, String> records = consumer.poll(100);

                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(String.format(
                            "topic = %s, partition = %s, key = %s, value = %s",
                            record.topic(), record.partition(),
                            record.key(), record.value()
                    ));
                    if (record.value().equals("done")) {
                        flag = false;
                    }
                }

                if (!flag) {
                    break;
                }
            }
        } finally {
            consumer.close();
        }
    }

    /**
     * 同步提交
     */
    private static void generalConsumeMessageSyncCommit() {

        properties.put("auto.commit.offset", false);
        consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList("imooc-kafka-study-x"));

        while (true) {
            boolean flag = true;

            ConsumerRecords<String, String> records =
                    consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(String.format(
                        "topic = %s, partition = %s, key = %s, value = %s",
                        record.topic(), record.partition(),
                        record.key(), record.value()
                ));
                if (record.value().equals("done")) {
                    flag = false;
                }
            }

            try {
                // 这里会阻塞
                // 如果提交失败会主动重试,如果在重试多次之后仍然提交失败,则抛出异常
                consumer.commitSync();
            } catch (CommitFailedException ex) {
                System.out.println("commit failed error: "
                        + ex.getMessage());
            }

            if (!flag) {
                break;
            }
        }
    }

    /**
     * 异步提交
     */
    private static void generalConsumeMessageAsyncCommit() {

        properties.put("auto.commit.offset", false);
        consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList("imooc-kafka-study-x"));

        while (true) {
            boolean flag = true;

            ConsumerRecords<String, String> records =
                    consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(String.format(
                        "topic = %s, partition = %s, key = %s, value = %s",
                        record.topic(), record.partition(),
                        record.key(), record.value()
                ));
                if (record.value().equals("done")) {
                    flag = false;
                }
            }

            // commit A, offset 2000
            // commit B, offset 3000
            // 异步提交速度快
            // 这里不会阻塞, 但是提交失败不会重试
            // 因为如果异步提交有重试机制的话,就不能保证提交的顺序性,可能会导致消息的重复消费
            consumer.commitAsync();

            if (!flag) {
                break;
            }
        }
    }

    /**
     * 带回调函数的异步提交
     */
    private static void generalConsumeMessageAsyncCommitWithCallback() {

        properties.put("auto.commit.offset", false);
        consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList("imooc-kafka-study-x"));

        while (true) {
            boolean flag = true;

            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(String.format(
                        "topic = %s, partition = %s, key = %s, value = %s",
                        record.topic(), record.partition(),
                        record.key(), record.value()
                ));
                if (record.value().equals("done")) {
                    flag = false;
                }
            }

            // 异步提交失败之后不要在做重试,就让其失败,只要把失败数据记录下来就好
            consumer.commitAsync((map, e) -> {
                // Map<TopicPartition, OffsetAndMetadata>
                if (e != null) {
                    System.out.println("commit failed for offsets: " + e.getMessage());
                    System.out.println("<TopicPartition, OffsetAndMetadata>: " + map);
                }
            });

            if (!flag) {
                break;
            }
        }
    }

    /**
     * 混合同步提交与异步提交
     */
    @SuppressWarnings("all")
    private static void mixSyncAndAsyncCommit() {

        properties.put("auto.commit.offset", false);
        consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList("imooc-kafka-study-x"));

        try {

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);

                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(String.format(
                            "topic = %s, partition = %s, key = %s, " +
                                    "value = %s",
                            record.topic(), record.partition(),
                            record.key(), record.value()
                    ));
                }

                // 先异步提交
                consumer.commitAsync();
            }
        } catch (Exception ex) {
            System.out.println("commit async error: " + ex.getMessage());
        } finally {
            // 如果异步提交失败,同步提交兜底
            try {
                consumer.commitSync();
            } finally {
                consumer.close();
            }
        }
    }

    public static void main(String[] args) {
        generalConsumeMessageAutoCommit();
    }
}
