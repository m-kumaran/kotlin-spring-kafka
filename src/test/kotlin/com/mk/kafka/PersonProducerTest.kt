package com.mk.kafka

import io.kotlintest.shouldBe
import io.kotlintest.specs.AnnotationSpec
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.test.EmbeddedKafkaBroker
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit.jupiter.SpringExtension


@SpringBootTest
@EmbeddedKafka
@DirtiesContext
@ExtendWith(value = [SpringExtension::class])
class PersonProducerTest : AnnotationSpec() {

    @Autowired
    lateinit var kafkaBroker: EmbeddedKafkaBroker

    @Test
    fun test() {
        //kafkaBroker shouldBe null
    }
}