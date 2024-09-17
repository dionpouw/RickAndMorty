package com.jefflete.rickandmorty.data.network

import com.jefflete.rickandmorty.data.network.response.character.CharacterResponse
import com.jefflete.rickandmorty.data.network.response.character.CharactersResponse
import com.jefflete.rickandmorty.data.network.response.episode.EpisodeResponse
import com.jefflete.rickandmorty.data.network.response.episode.EpisodesResponse
import com.jefflete.rickandmorty.data.network.response.location.LocationResponse
import com.jefflete.rickandmorty.data.network.response.location.LocationsResponse

interface RemoteDataSource {
    suspend fun getCharacter(id: Int): CharacterResponse
    suspend fun getCharacters(): CharactersResponse
    suspend fun getLocations(): LocationsResponse
    suspend fun getLocation(id: Int): LocationResponse
    suspend fun getEpisode(id: Int): EpisodeResponse
    suspend fun getEpisodes(): EpisodesResponse
}