package com.dog.breed.model

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import io.r2dbc.postgresql.codec.Json

@Table("Dog")
class Dog {

    @Column("metadata")
    lateinit var metadata: Json
}