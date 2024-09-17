package com.jefflete.rickandmorty.data.network.response.episode

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodeResponse(

    @field:SerializedName("air_date")
    val airDate: String,

    @field:SerializedName("characters")
    val characters: List<String>,

    @field:SerializedName("created")
    val created: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("episode")
    val episode: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("url")
    val url: String
) : Parcelable
