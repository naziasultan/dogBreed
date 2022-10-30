package com.dog.breed.model

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("image")
class Image {

    @Column("imageUrl")
    lateinit var imageUrl: Json
}