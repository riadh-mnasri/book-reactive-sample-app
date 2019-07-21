package com.wehightech.bbl

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import org.springframework.web.reactive.function.server.bodyToServerSentEvents
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.time.Duration


@Component
class BooksHandler(private val repository: BookRepository) {

    fun getAll(request: ServerRequest): Mono<ServerResponse> {
        val interval = Flux.interval(Duration.ofSeconds(1))

        val books = repository.findAll()
        return ok().bodyToServerSentEvents(Flux.zip(interval, books).map { it.t2 })
    }

    fun getBook(request: ServerRequest): Mono<ServerResponse> {
        val name = request.pathVariable("name")

        return ok().body(repository.findByName(name))
    }

    fun addBook(request: ServerRequest): Mono<ServerResponse> {
        val book = request.bodyToMono<Book>()

        return ok().body(repository.saveAll(book).toMono())
    }
}
