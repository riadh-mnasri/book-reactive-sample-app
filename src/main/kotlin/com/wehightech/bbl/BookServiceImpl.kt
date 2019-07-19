package com.wehightech.bbl

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BookServiceImpl(val bookRepository: BookRepository): BookService {

    override fun create(book: Book) {
        bookRepository!!.save(book).subscribe()
    }

    override fun findById(id: Int): Mono<Book> {
        return bookRepository!!.findById(id)
    }

    override fun findByName(name: String): Flux<Book> {
        return bookRepository!!.findByName(name)
    }

    override fun findAll(): Flux<Book> {
        return bookRepository!!.findAll()
    }

    override fun update(book: Book): Mono<Book> {
        return bookRepository!!.save(book)
    }

    override fun delete(id: Int): Mono<Void> {
        return bookRepository!!.deleteById(id)
    }
}
