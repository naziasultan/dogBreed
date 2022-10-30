package com.dog.breed

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BreedApplication

fun main(args: Array<String>) {
	runApplication<BreedApplication>(*args)
}
