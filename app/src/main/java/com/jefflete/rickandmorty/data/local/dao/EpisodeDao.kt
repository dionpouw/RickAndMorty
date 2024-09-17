package com.jefflete.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jefflete.rickandmorty.data.local.model.EpisodeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EpisodeDao {
    @Query("SELECT * FROM episodeentity WHERE id = :id")
    fun getEpisode(id: Int): Flow<EpisodeEntity>

    @Query("SELECT * FROM episodeentity")
    fun getEpisodes(): Flow<List<EpisodeEntity>>

    @Insert
    suspend fun insertEpisode(episode: EpisodeEntity)

    @Delete
    suspend fun deleteEpisode(episode: EpisodeEntity)
}