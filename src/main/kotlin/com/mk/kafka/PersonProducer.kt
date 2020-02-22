package com.mk.kafka

import com.mk.model.Person
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFutureCallback

@Component
class PersonProducer(@Autowired val kafkaTemplate: KafkaTemplate<String,Person>) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun send(person: Person) {
        val record: ProducerRecord<String, Person> = ProducerRecord(PersonProducerConfig.TOPIC, person)
        log.info("Producer sending $person")
        kafkaTemplate.send(record).addCallback(object : ListenableFutureCallback<SendResult<String, Person>> {
            override fun onSuccess(result: SendResult<String, Person>?) {
                log.info("SENT: record=[$record] \n result.recordMetadata= ${result?.recordMetadata} \n partition= ${result?.recordMetadata?.partition()}")
            }
            override fun onFailure(e: Throwable) = log.error("ERROR ${e.message}")
        })
    }

}