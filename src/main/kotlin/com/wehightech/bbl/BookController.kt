package com.wehightech.bbl

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping(value = "/books")
class BookController(val bookService: BookService) {

    @RequestMapping(value = ["/create", "/"],  method = [RequestMethod.POST], consumes=[MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun create(@RequestBody book: Book) {
        bookService!!.create(book)
    }

    @RequestMapping(value = "/{id}", method = [RequestMethod.GET])
    @ResponseBody
    fun findById(@PathVariable("id") id: Int): ResponseEntity<Mono<Book>> {
        val foundBook = bookService!!.findById(id)
        val status = if (foundBook != null) HttpStatus.OK else HttpStatus.NOT_FOUND
        return ResponseEntity(foundBook, status)
    }

    @RequestMapping(value = "/name/{name}", method = [RequestMethod.GET])
    @ResponseBody
    fun findByName(@PathVariable("name") name: String): Flux<Book> {
        return bookService!!.findByName(name)
    }

    @RequestMapping(method = [RequestMethod.GET], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    @ResponseBody
    fun findAll(): Flux<Book> {
        return bookService!!.findAll()
    }

    @RequestMapping(value = "/update", method = [RequestMethod.PUT])
    @ResponseStatus(HttpStatus.OK)
    fun update(@RequestBody bookToUpdate: Book): Mono<Book> {
        return bookService!!.update(bookToUpdate)
    }

    @RequestMapping(value = "/delete/{id}", method = [RequestMethod.DELETE])
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable("id") id: Int) {
        bookService!!.delete(id).subscribe()
    }

}
