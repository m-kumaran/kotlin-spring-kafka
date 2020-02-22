package com.mk.kafka

import com.mk.model.Person
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer


@Configuration
class PersonConsumerConfig {
    private val log = LoggerFactory.getLogger(javaClass)

    @Value("\${kafka.bootstrap-servers}")
    private val bootstrapServers: String? = null

    @Bean
    fun getConfig(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers!!
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        props[ConsumerConfig.GROUP_ID_CONFIG] = "group-1"
        return props
    }

    @Bean
    fun consumerFactory(): ConsumerFactory<String, Person> {
        val personDeSerializer = JsonDeserializer<Person>()
        personDeSerializer.addTrustedPackages("*");
        return DefaultKafkaConsumerFactory<String, Person>(getConfig(), StringDeserializer(), personDeSerializer)
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Person> {
        return ConcurrentKafkaListenerContainerFactory<String, Person>().also {
            it.setConsumerFactory(consumerFactory())
        }
    }

}