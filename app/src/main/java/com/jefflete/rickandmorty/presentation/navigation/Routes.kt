package com.jefflete.rickandmorty.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    @Serializable
    data object CharacterList : Routes()

    @Serializable
    data class CharacterDetail(val id: String) : Routes()

    @Serializable
    data object LocationList : Routes()

    @Serializable
    data class LocationDetail(val id: String) : Routes()

    @Serializable
    data object EpisodeList : Routes()

    @Serializable
    data class EpisodeDetail(val id: String) : Routes()
}

//@Serializable
//@Parcelize
//data class ScreenInfo(val route:String, val id:String):Parcelable