package com.jefflete.rickandmorty.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EpisodeEntity(
    val airDate: String, val characters: List<String>, val created: String,

    val name: String,

    val episode: String,

    @PrimaryKey val id: Int,

    val url: String
)
