package com.jefflete.rickandmorty.data.network.response.character

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterResponse(

    @field:SerializedName("image")
    val image: String,

    @field:SerializedName("gender")
    val gender: String,

    @field:SerializedName("species")
    val species: String,

    @field:SerializedName("created")
    val created: String,

    @field:SerializedName("origin")
    val origin: CharacterResponseOrigin,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("location")
    val location: CharacterResponseLocation,

    @field:SerializedName("episode")
    val episode: List<String>,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("status")
    val status: String
) : Parcelable

@Parcelize
data class CharacterResponseOrigin(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("url")
    val url: String
) : Parcelable

@Parcelize
data class CharacterResponseLocation(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("url")
    val url: String
) : Parcelable
