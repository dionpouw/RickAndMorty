package com.jefflete.rickandmorty.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val image: String,
    val gender: String,
    val species: String,
    val created: String,
    val origin: Origin,
    val name: String,
    val location: Location,
    val episode: List<String>,
    val id: Int,
    val type: String,
    val url: String,
    val status: String
) : Parcelable

@Parcelize
data class Origin(
    @field:SerializedName("name") val name: String, @field:SerializedName("url") val url: String
) : Parcelable

@Parcelize
data class Location(
    @field:SerializedName("name") val name: String, @field:SerializedName("url") val url: String
) : Parcelable