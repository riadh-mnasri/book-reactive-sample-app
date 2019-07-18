package com.wehightech.bbl

import reactor.core.publisher.Mono
import reactor.core.publisher.Flux



interface BookService {
    fun create(book: Book)

    fun findById(id: Int): Mono<Book>

    fun findByName(name: String): Flux<Book>

    fun findAll(): Flux<Book>

    fun update(book: Book): Mono<Book>

    fun delete(id: Int): Mono<Void>
}
