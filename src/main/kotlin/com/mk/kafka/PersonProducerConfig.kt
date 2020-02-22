package com.mk.kafka

import com.mk.model.Person
import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer
import java.util.*

@Configuration
class PersonProducerConfig {

    @Value("\${kafka.bootstrap-servers}")
    private val bootstrapServers: String? = null

    @Bean
    fun producerConfigs(): Map<String, Any?> {
        val props: MutableMap<String, Any?> = HashMap()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        return props
    }

    @Bean
    fun newTopic(): NewTopic = NewTopic(TOPIC, 2, 1)

    @Bean
    fun producerFactory(): ProducerFactory<String, Person> = DefaultKafkaProducerFactory<String, Person>(producerConfigs())

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Person> = KafkaTemplate<String, Person>(producerFactory())
//
//    @Bean
//    fun producer(): Producer = Producer(kafkaTemplate())

    companion object {
        const val TOPIC = "user-visit"
    }
}