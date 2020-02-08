package com.mk.springkafkakotlin

import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFutureCallback

@Component
class Producer(private val kafkaTemplate: KafkaTemplate<String, String>) {

    val topic = "user-signup"

    @Bean
    fun newTopic(): NewTopic = NewTopic(topic, 2, 1)

    fun send(message: String) {
        val record: ProducerRecord<String, String> = ProducerRecord(topic, message)
        kafkaTemplate.send(record).addCallback(object : ListenableFutureCallback<SendResult<String?, String?>?> {
            override fun onSuccess(result: SendResult<String?, String?>?) {
                println("message=[$message] \n recordMetadata= ${result?.recordMetadata} \n partition= ${result?.recordMetadata?.partition()}")
            }

            override fun onFailure(e: Throwable) = println("ERROR ${e.message}")
        })
    }


}