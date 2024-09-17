package com.jefflete.rickandmorty.data.network.response.episode

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodesResponse(

    @field:SerializedName("results")
    val results: List<ResultsItem>,

    @field:SerializedName("info")
    val info: Info
) : Parcelable

@Parcelize
data class ResultsItem(

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

@Parcelize
data class Info(

    @field:SerializedName("next")
    val next: String,

    @field:SerializedName("pages")
    val pages: Int,

    @field:SerializedName("prev")
    val prev: String?,

    @field:SerializedName("count")
    val count: Int
) : Parcelable
