package com.jefflete.rickandmorty.domain.repository

import com.jefflete.rickandmorty.data.local.model.EpisodeEntity
import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Episode
import kotlinx.coroutines.flow.Flow

interface EpisodeRepository {
    suspend fun getEpisode(): Flow<List<Episode>>
    suspend fun getEpisode(id: Int): Flow<Episode>
    suspend fun saveEpisode(episode: EpisodeEntity)
    suspend fun deleteEpisode(episode: EpisodeEntity)
    suspend fun getNetworkEpisode(id: Int): Flow<Result<Episode>>
    suspend fun getNetworkEpisodes(): Flow<Result<List<Episode>>>
}