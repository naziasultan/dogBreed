package com.dog.breed.service

import com.dog.breed.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class DogService {

    lateinit var repo: MessageRepository
   lateinit var template: R2dbcEntityTemplate

    @Autowired
    lateinit var webClient: WebClient
    suspend fun getBreed() : Object{


        var dog = webClient.get()
            .uri("/api/breeds/list/all")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve().awaitBody<Object>()
        template.insert(dog)
        return dog
    }

    suspend fun getBreed(name: String) : Object{
       var image = webClient.get()
            .uri("api/breed/{name}/images")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve().awaitBody<Object>()
        template.insert(image)
        return image
    }
}