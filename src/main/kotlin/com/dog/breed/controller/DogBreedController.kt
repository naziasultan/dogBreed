package com.dog.breed.controller

import com.dog.breed.model.Dog
import com.dog.breed.service.DogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api")
class DogBreedController {
    /**
     * FIXME: Spring recommends using constructor/setter injection.
     * FIXME: See https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-setter-injection
     */
    lateinit var service: DogService


    @GetMapping("/breed")
    suspend fun getAllBreed() {
        service.getBreed()
    }

    @GetMapping("/breed")
    suspend fun getBreed(@PathVariable name: String) {
        service.getBreed(name)
    }

}