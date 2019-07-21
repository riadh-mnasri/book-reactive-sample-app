package com.wehightech.bbl

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class ReactiveKotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(ReactiveKotlinApplication::class.java, *args)
}
