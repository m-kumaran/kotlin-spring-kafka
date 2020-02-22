package com.mk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.kafka.annotation.EnableKafka
import java.time.Clock

@SpringBootApplication
@EnableKafka
class App {
    @Bean
    fun systemClock(): Clock = Clock.systemUTC()
}

fun main(args: Array<String>) {
    runApplication<App>(*args)
}
