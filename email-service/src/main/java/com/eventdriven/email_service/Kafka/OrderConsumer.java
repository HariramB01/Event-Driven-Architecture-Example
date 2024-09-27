package com.eventdriven.email_service.Kafka;

import com.eventdriven.base_domains.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);


    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    private void consumer(OrderEvent event){
        System.out.println("-------------------");
        LOGGER.info(String.format("Order event received in stock service : -> ", event.toString()));
        System.out.println(event.toString());
        System.out.println("-------------------");
    }

}
