package com.example.kafka.mq;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
 
@Component
public class Consume {

    @KafkaListener(id = "riskConsume",
            topics = "RISK",groupId = "RISK")
    public void listenT22(ConsumerRecord<String, String> cr) throws Exception {
        System.out.println("消费者22222：：：：："+cr.topic()+",,"+cr.key()+",,,,"+cr.value());
        String msg = cr.value();
        System.out.println(msg);
    }
}
