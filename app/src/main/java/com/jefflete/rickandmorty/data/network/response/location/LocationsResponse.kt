package com.jefflete.rickandmorty.data.network.response.location

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationsResponse(

    @field:SerializedName("results")
    val results: List<ResultsItem>,

    @field:SerializedName("info")
    val info: Info
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

@Parcelize
data class ResultsItem(

    @field:SerializedName("created")
    val created: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("residents")
    val residents: List<String>,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("dimension")
    val dimension: String,

    @field:SerializedName("url")
    val url: String
) : Parcelable
