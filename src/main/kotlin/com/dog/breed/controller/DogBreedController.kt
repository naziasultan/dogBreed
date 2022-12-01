package com.dog.breed.controller

import com.dog.breed.model.Dog
import com.dog.breed.service.DogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api")
public class DogBreedController { //Done: FIXME: Name class per its purpose, e.g. DogBreedController
   lateinit var service : DogService


    @GetMapping ("/breed")
    suspend fun getAllBreed() { //Done: FIXME: Object class is from Java world, kotlin.Any class is from Kotlin world.
       service.getBreed() //Done: FIXME: you can use expression body instead of return statement (preferred, per kotlin code conventions)
    }

    @GetMapping ("/breed")
    suspend fun getBreed(@PathVariable name : String) { //Done FIXME: Object class is from Java world, kotlin.Any class is from Kotlin world.
         service.getBreed(name) // Done: FIXME: you can use expression body instead of return statement (preferred, per kotlin code conventions)
    }

}