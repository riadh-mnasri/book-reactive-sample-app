package com.wehightech.bbl

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface BookRepository : ReactiveCrudRepository<Book, String> {
    fun findByName(name: String): Mono<Book>
}
