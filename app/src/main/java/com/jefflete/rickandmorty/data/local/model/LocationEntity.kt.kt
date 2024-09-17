package com.jefflete.rickandmorty.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationEntity(

    val created: String,

    val name: String,

    val residents: List<String>,

    @PrimaryKey val id: Int,

    val type: String,

    val dimension: String,

    val url: String
)
