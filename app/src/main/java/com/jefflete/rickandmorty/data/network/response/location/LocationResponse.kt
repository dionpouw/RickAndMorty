package com.jefflete.rickandmorty.data.network.response.location

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationResponse(

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
