package com.dog.breed.service

import com.dog.breed.model.Dog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

//FIXME: class is not properly formatted
@Service
class DogService {

    lateinit var template: R2dbcEntityTemplate //FIXME: you need to use a dedicated for coroutines repository instead -> CoroutineCrudRepository

    /**
     * FIXME: Spring recommends using constructor/setter injection.
     * FIXME: See https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-setter-injection
     */
    @Autowired
    lateinit var webClient: WebClient
    suspend fun getBreed(): Dog { // Done: FIXME: Object class is from Java world, kotlin.Any class is from Kotlin world.
        val dog = webClient.get() //Done: FIXME: why var, not val?
            .uri("/api/breeds/list/all")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve().awaitBody<Dog>()
        template.insert(dog)
        return dog
    }

    suspend fun getBreed(name: String): Dog { //Done: FIXME: Object class is from Java world, kotlin.Any class is from Kotlin world.
        val image = webClient.get() //Done: FIXME: why var, not val?
            .uri("api/breed/{name}/images")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve().awaitBody<Dog>()
        template.insert(image)
        return image
    }
}