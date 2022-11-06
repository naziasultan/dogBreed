package com.dog.breed.repository

import com.dog.breed.model.Dog
import org.springframework.data.r2dbc.repository.R2dbcRepository

//FIXME: not used, please remove
interface MessageRepository : R2dbcRepository<Dog?, Int?>