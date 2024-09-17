package com.jefflete.rickandmorty.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val image: String,
    val gender: String,
    val species: String,
    val created: String,
    val origin: CharacterOriginEntity,
    val name: String,
    val location: CharacterLocationEntity,
    val episode: List<String>,
    val type: String,
    val url: String,
    val status: String
)

data class CharacterOriginEntity(
    val name: String,
    val url: String
)

data class CharacterLocationEntity(
    val name: String,
    val url: String
)

