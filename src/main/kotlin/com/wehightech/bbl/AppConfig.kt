package com.wehightech.bbl

import org.springframework.core.io.ClassPathResource
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class AppConfig {
    @Bean
    fun getPropertyPlaceholderConfigurer(): PropertyPlaceholderConfigurer {
        val ppc = PropertyPlaceholderConfigurer()
        ppc.setLocation(ClassPathResource("application.properties"))
        ppc.setIgnoreUnresolvablePlaceholders(true)
        return ppc
    }
}
