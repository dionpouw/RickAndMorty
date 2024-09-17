package com.jefflete.rickandmorty.data.network

import com.jefflete.rickandmorty.data.network.api.ApiService
import com.jefflete.rickandmorty.data.network.response.character.CharacterResponse
import com.jefflete.rickandmorty.data.network.response.character.CharactersResponse
import com.jefflete.rickandmorty.data.network.response.episode.EpisodeResponse
import com.jefflete.rickandmorty.data.network.response.episode.EpisodesResponse
import com.jefflete.rickandmorty.data.network.response.location.LocationResponse
import com.jefflete.rickandmorty.data.network.response.location.LocationsResponse

class RemoteDataSourceImpl(private val api: ApiService) : RemoteDataSource {
    override suspend fun getCharacter(id: Int): CharacterResponse = api.getCharacter(id)
    override suspend fun getCharacters(): CharactersResponse = api.getCharacters()
    override suspend fun getLocations(): LocationsResponse = api.getLocations()
    override suspend fun getLocation(id: Int): LocationResponse = api.getLocation(id)
    override suspend fun getEpisode(id: Int): EpisodeResponse = api.getEpisode(id)
    override suspend fun getEpisodes(): EpisodesResponse = api.getEpisodes()
}