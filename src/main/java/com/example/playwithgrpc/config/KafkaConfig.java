package com.example.playwithgrpc.config;

import com.example.playwithgrpc.model.dto.EventMessage;
import com.example.playwithgrpc.model.entity.Account;
import com.example.playwithgrpc.model.event.Event;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@Slf4j
public class KafkaConfig {
    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    @Bean
    ProducerFactory<String, EventMessage> eventProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, EventMessage> eventKafkaTemplate() {
        return new KafkaTemplate<>(eventProducerFactory());
    }

//    @Bean
//    KafkaTemplate<String, String> kafkaTemplate() {
//        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory());
//        kafkaTemplate.setMessageConverter(new StringJsonMessageConverter());
//        kafkaTemplate.setDefaultTopic("reflectoring-user");
//        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
//            @Override
//            public void onSuccess(ProducerRecord<String, String> producerRecord, RecordMetadata recordMetadata) {
//                log.info("ACK from ProducerListener message: {} offset:  {}", producerRecord.value(),
//                        recordMetadata.offset());
//            }
//        });
//        return kafkaTemplate;
//    }

//    @Bean
//    public ProducerFactory<String, Account> userProducerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }



    Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "reflectoring-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
        return props;
    }

    ConsumerFactory<String, EventMessage> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(),
                new StringDeserializer(),
                new JsonDeserializer<>(EventMessage.class));
    }

    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, EventMessage>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, EventMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
//        factory.setReplyTemplate(kafkaTemplate());
        // Comment the RecordFilterStrategy if Filtering is not required
//        factory.setRecordFilterStrategy(record -> record.value().contains("ignored"));
        return factory;
    }

//    public ConsumerFactory<String, Account> userConsumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "reflectoring-user");
//        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(Account.class));
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Account> userKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, Account> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(userConsumerFactory());
//        return factory;
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaJsonListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        factory.setMessageConverter(new StringJsonMessageConverter());
//        return factory;
//    }
}
