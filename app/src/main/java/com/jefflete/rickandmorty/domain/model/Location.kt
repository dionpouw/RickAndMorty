package com.jefflete.rickandmorty.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val created: String,
    val name: String,
    val residents: List<String>,
    val id: Int,
    val type: String,
    val dimension: String,
    val url: String
) : Parcelable
