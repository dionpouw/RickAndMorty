package com.jefflete.rickandmorty.data.local

import com.jefflete.rickandmorty.data.local.db.AppDatabase
import com.jefflete.rickandmorty.data.local.model.CharacterEntity
import com.jefflete.rickandmorty.data.local.model.EpisodeEntity
import com.jefflete.rickandmorty.data.local.model.LocationEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(private val db: AppDatabase) : LocalDataSource {
    override fun getCharacter(id: Int): Flow<CharacterEntity> = db.characterDao().getCharacter(id)

    override fun getCharacters(): Flow<List<CharacterEntity>> = db.characterDao().getCharacters()

    override fun getLocations(): Flow<List<LocationEntity>> = db.locationDao().getLocations()

    override fun getLocation(id: Int): Flow<LocationEntity> = db.locationDao().getLocation(id)

    override fun getEpisode(id: Int): Flow<EpisodeEntity> = db.episodeDao().getEpisode(id)

    override fun getEpisodes(): Flow<List<EpisodeEntity>> = db.episodeDao().getEpisodes()

    override suspend fun saveCharacter(character: CharacterEntity) =
        db.characterDao().insertCharacter(character)

    override suspend fun saveLocation(location: LocationEntity) =
        db.locationDao().insertLocation(location)

    override suspend fun saveEpisode(episode: EpisodeEntity) =
        db.episodeDao().insertEpisode(episode)

    override suspend fun deleteCharacter(character: CharacterEntity) =
        db.characterDao().deleteCharacter(character)

    override suspend fun deleteLocation(location: LocationEntity) =
        db.locationDao().deleteLocation(location)

    override suspend fun deleteEpisode(episode: EpisodeEntity) =
        db.episodeDao().deleteEpisode(episode)
}