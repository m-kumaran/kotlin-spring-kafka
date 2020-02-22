package com.mk.api

import com.mk.kafka.PersonProducer
import com.mk.model.Person
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Clock
import java.time.ZonedDateTime

@RestController
@RequestMapping("/api")
class Api constructor(private val producer: PersonProducer, val systemClock: Clock) {
    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("/person")
    fun sendMessage(@RequestBody person: Person): Map<String, String> {
        producer.send(person.copy(inTime = ZonedDateTime.now(systemClock)))
        return mapOf<String, String>("result" to "OK")
    }

}

