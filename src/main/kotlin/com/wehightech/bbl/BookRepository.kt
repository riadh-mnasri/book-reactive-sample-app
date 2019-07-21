package com.wehightech.bbl

import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux


interface BookRepository : ReactiveMongoRepository<Book, Int> {
    @Query("{ 'name': ?0 }")
    fun findByName(name: String): Flux<Book>
}
