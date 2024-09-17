package com.jefflete.rickandmorty.data.network.response.episode

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodesResponse(

    @field:SerializedName("results") val results: List<EpisodeResponse>,

    @field:SerializedName("info") val info: Info
) : Parcelable

@Parcelize
data class Info(

    @field:SerializedName("next") val next: String,

    @field:SerializedName("pages") val pages: Int,

    @field:SerializedName("prev") val prev: String?,

    @field:SerializedName("count") val count: Int
) : Parcelable
