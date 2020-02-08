package com.mk.springkafkakotlin

import org.apache.kafka.clients.admin.NewTopic
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Component
class Consumer {

    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["user-signup"], groupId = "consumer-group1", autoStartup = "\${custom-configs.auto-start:true}")
    fun processMessage(message: String) {
        logger.info("got message: {}", message)
    }

}
