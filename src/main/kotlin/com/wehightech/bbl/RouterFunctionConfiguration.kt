package com.wehightech.bbl

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router


@Configuration
class AppRoutes(private val bookHandler: BookHandler) {

    @Bean
    fun apis() = router {
        (accept(APPLICATION_JSON) and "/books").nest {
            GET("/", bookHandler::getAll)
            POST("/create", bookHandler::addBook)
        }
    }

}
