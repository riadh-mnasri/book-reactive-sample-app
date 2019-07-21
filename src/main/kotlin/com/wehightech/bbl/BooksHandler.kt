package com.wehightech.bbl

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.time.Duration


@Document
data class Book(@Id val id: String,
                val name: String,
                val isbn: String?)

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

@Repository
interface BookRepository : ReactiveCrudRepository<Book, String> {
    fun findByName(name: String): Mono<Book>
}
