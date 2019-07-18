package com.wehightech.bbl

import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
class Book {

    @Id
    var id: Int = 0
    var name: String? = null
    var isbn: String? = null

    override fun toString(): String {
        return "Book [id=$id, name=$name, isbn=$isbn]"
    }
}
