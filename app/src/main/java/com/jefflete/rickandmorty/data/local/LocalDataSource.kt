package com.jefflete.rickandmorty.data.local

import com.jefflete.rickandmorty.data.local.model.CharacterEntity
import com.jefflete.rickandmorty.data.local.model.EpisodeEntity
import com.jefflete.rickandmorty.data.local.model.LocationEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getCharacter(id: Int): Flow<CharacterEntity>
    fun getCharacters(): Flow<List<CharacterEntity>>
    fun getLocations(): Flow<List<LocationEntity>>
    fun getLocation(id: Int): Flow<LocationEntity>
    fun getEpisode(id: Int): Flow<EpisodeEntity>
    fun getEpisodes(): Flow<List<EpisodeEntity>>
    suspend fun saveCharacter(character: CharacterEntity)
    suspend fun saveLocation(location: LocationEntity)
    suspend fun saveEpisode(episode: EpisodeEntity)
    suspend fun deleteCharacter(character: CharacterEntity)
    suspend fun deleteLocation(location: LocationEntity)
    suspend fun deleteEpisode(episode: EpisodeEntity)
}