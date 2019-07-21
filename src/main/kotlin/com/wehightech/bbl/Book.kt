package com.wehightech.bbl

import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
data class Book(@Id val id: Int, val name: String="", val isbn: String)
