package com.Microservices.ProducerService.EnseignantEvent;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class AddEventProducer {

    private NewTopic topic;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    public AddEventProducer(NewTopic topic, KafkaTemplate<String, AddEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendEvent(AddEvent addEvent) {

        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic.name(), addEvent);
        future.whenComplete((result, exception)->{
            if(exception == null) {
                System.out.println("add Enseignant " + addEvent.toString() +
                        "\n in Partition: " + result.getRecordMetadata().partition() +
                            "\n with Offset: " + result.getRecordMetadata().offset() +
                                "\n---------------------------------------- ");
            } else {
                System.out.println("Enseignant failed to added" + exception.getMessage());
            }
        });
    }
}
