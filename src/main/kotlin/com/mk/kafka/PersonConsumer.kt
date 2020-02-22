package com.mk.kafka

import com.mk.model.Person
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component
import java.util.*


@Component
class PersonConsumer {

    private val log = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["user-visit"], groupId = "consumer-group1", autoStartup = "\${custom-configs.auto-start:true}")
    fun consumer1(record: ConsumerRecord<String, Person>) {
        log.info("RECEIVED: consumer consumed the record : {}", record)
    }


}
