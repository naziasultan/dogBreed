package com.dog.breed.controller

import com.dog.breed.service.DogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api")
public class DogBreed {
   lateinit var service : DogService


    @GetMapping ("/breed")
    suspend fun getAllBreed(): Object {
       return service.getBreed()
    }

    @GetMapping ("/breed")
    suspend fun getBreed(@PathVariable name : String): Object {
        return service.getBreed(name)
    }

}