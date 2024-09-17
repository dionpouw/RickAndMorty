package com.jefflete.rickandmorty.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val image: String,
    val gender: String,
    val species: String,
    val created: String,
    val origin: CharacterOrigin,
    val name: String,
    val location: CharacterLocation,
    val episode: List<String>,
    val id: Int,
    val type: String,
    val url: String,
    val status: String
) : Parcelable

@Parcelize
data class CharacterOrigin(
    val name: String, val url: String
) : Parcelable

@Parcelize
data class CharacterLocation(
    val name: String, val url: String
) : Parcelable