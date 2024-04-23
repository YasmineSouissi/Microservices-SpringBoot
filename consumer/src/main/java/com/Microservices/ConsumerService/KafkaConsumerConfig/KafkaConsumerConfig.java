package com.Microservices.ConsumerService.KafkaConsumerConfig;

import com.Microservices.ConsumerService.AddEvent.AddEvent;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, AddEvent> consumerFactory() {
        JsonDeserializer<AddEvent> deserializer = new JsonDeserializer<>(AddEvent.class);
        deserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(
                Map.of(
                        org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                        org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "Add-service-consumer",
                        org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"
                ),
                new StringDeserializer(), // Key deserializer
                new ErrorHandlingDeserializer<>(deserializer) // Value deserializer
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, AddEvent> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AddEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
