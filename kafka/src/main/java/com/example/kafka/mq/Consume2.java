package com.example.kafka.mq;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consume2 {

    @KafkaListener(id = "riskConsume2",
            topics = "RISK",groupId = "RISK2")
    /*groupId不相同而topics相同，就变成了广播，消息会被重复消费*/
    public void listenT22(ConsumerRecord<String, String> cr) throws Exception {
        System.out.println("消费者22222：：：：："+cr.topic()+",,"+cr.key()+",,,,"+cr.value());
        String msg = cr.value();
        System.out.println(msg);
    }
}
