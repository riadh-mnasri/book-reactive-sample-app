package com.wehightech.bbl

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients

@Configuration
@EnableReactiveMongoRepositories(basePackages = ["com.wehightech.bbl"])
class MongoConfig : AbstractReactiveMongoConfiguration() {
    @Value("\${port}")
    private lateinit var port: String

    @Value("\${dbname}")
    private lateinit var databaseName: String

    override fun reactiveMongoClient(): MongoClient {
        return MongoClients.create()
    }

    override fun getDatabaseName(): String {
        return databaseName
    }

    @Bean
    override fun reactiveMongoTemplate(): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(reactiveMongoClient(), databaseName)
    }
}
