package com.wehightech.bbl

import reactor.core.publisher.Mono
import reactor.core.publisher.Flux



interface BookService {
    fun create(book: Mono<Book>): Mono<Void>

    fun findById(id: Int): Mono<Book>

    fun findByName(name: String): Flux<Book>

    fun findAll(): Flux<Book>

    //fun update(book: Mono<Book>): Mono<Book>

    fun delete(id: Int): Mono<Void>
}
