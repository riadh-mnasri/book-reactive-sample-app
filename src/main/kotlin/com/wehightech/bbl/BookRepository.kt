package com.wehightech.bbl

import org.springframework.data.mongodb.repository.Query
import reactor.core.publisher.Flux
import org.springframework.data.mongodb.repository.ReactiveMongoRepository


interface BookRepository : ReactiveMongoRepository<Book, Int> {
    @Query("{ 'name': ?0 }")
    fun findByName(name: String): Flux<Book>
}
