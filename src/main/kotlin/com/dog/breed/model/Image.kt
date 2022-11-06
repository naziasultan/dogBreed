package com.dog.breed.model

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

//FIXME: Data classes best fit for such case
//FIXME: It's not used
@Table("image")
class Image {

    @Column("imageUrl")
    lateinit var imageUrl: Json
}