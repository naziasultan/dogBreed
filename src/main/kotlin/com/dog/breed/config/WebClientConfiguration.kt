package com.dog.breed.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfiguration {
    @Bean
    fun webclient(): WebClient {
        val size = 16 * 1024 * 1024
        val strategies =
            ExchangeStrategies.builder()
                .codecs { codecs: ClientCodecConfigurer ->
                    codecs.defaultCodecs().maxInMemorySize(size)
                }
                .build()
        return WebClient
            .builder()
            .baseUrl("https://dog.ceo")
            .defaultCookie("cookieKey", "cookieValue")
            .exchangeStrategies(strategies)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
    }
}