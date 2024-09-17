package com.jefflete.rickandmorty.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Episode(
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val name: String,
    val episode: String,
    val id: Int,
    val url: String
) : Parcelable
