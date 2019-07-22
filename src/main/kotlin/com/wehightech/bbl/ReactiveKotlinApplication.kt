package com.wehightech.bbl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class ReactiveKotlinApplication

fun main(args: Array<String>) {
    runApplication<ReactiveKotlinApplication>(*args)
}
