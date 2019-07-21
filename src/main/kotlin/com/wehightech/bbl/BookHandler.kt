package com.wehightech.bbl

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToServerSentEvents
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration


@Component
class BookHandler(val bookService: BookService) {

    /*fun getAll(request: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok().body(fromObject(bookService.findAll()))*/

    /* fun getAll(request: ServerRequest): Mono<ServerResponse> {
         val foundBooks = bookService.findAll()
         return ServerResponse.ok().body(foundBooks, Book::class.java)
     }*/

    fun getAll(request: ServerRequest): Mono<ServerResponse> {
        val interval = Flux.interval(Duration.ofSeconds(1))
        val books = bookService.findAll()
        return ServerResponse.ok().bodyToServerSentEvents((Flux.zip(interval, books).map { it.t2 }))
    }

    /*fun create(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(Book::class.java).flatMap { m ->
            val person = request.bodyToMono(Book::class.java)
            bookService.create(person)
            ServerResponse.status(CREATED).body(fromObject(m))
        }
    }*/

    fun addBook(request: ServerRequest): Mono<ServerResponse> {
        val person = request.bodyToMono(Book::class.java)
        return ServerResponse.ok().build(this.bookService.create(person))
    }

    /*
    fun create(request: ServerRequest): Mono<ServerResponse> {
        val book = request.bodyToMono(Book::class.java)
        return ServerResponse.ok().build(this.bookService.create(book))
    }
    */

}

