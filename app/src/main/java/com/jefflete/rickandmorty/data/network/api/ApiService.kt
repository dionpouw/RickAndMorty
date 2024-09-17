package com.jefflete.rickandmorty.data.network.api

import com.jefflete.rickandmorty.data.network.response.character.CharacterResponse
import com.jefflete.rickandmorty.data.network.response.character.CharactersResponse
import com.jefflete.rickandmorty.data.network.response.episode.EpisodeResponse
import com.jefflete.rickandmorty.data.network.response.episode.EpisodesResponse
import com.jefflete.rickandmorty.data.network.response.location.LocationResponse
import com.jefflete.rickandmorty.data.network.response.location.LocationsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("character/{id}")
    suspend fun getCharacter(id: Int): CharacterResponse

    @GET("character")
    suspend fun getCharacters(): CharactersResponse

    @GET("location/{id}")
    suspend fun getLocation(id: Int): LocationResponse

    @GET("location")
    suspend fun getLocations(): LocationsResponse

    @GET("episode/{id}")
    suspend fun getEpisode(id: Int): EpisodeResponse

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

}