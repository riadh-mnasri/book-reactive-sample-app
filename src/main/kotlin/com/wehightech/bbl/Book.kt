package com.wehightech.bbl

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Book(@Id val id: String,
                val name: String,
                val isbn: String?)
