package com.mk.springkafkakotlin

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class Api(private val kotlinProducer: Producer) {

    @PostMapping("/message")
    fun publish(@RequestBody message: String) {
        kotlinProducer.send(message)
    }

}

