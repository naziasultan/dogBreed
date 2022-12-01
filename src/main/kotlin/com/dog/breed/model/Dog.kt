package com.dog.breed.model

import kafka.utils.Json
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

//FIXME: Data classes best fit for such case
@Table("Dog")
class Dog {

    @Column("metadata")
    lateinit var metadata : Json //FIXME: why Json? I had intention to use NoSQL instead of SQL
}