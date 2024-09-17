package com.jefflete.rickandmorty.data.repository

import com.jefflete.rickandmorty.data.local.LocalDataSource
import com.jefflete.rickandmorty.data.local.model.EpisodeEntity
import com.jefflete.rickandmorty.data.network.RemoteDataSource
import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Episode
import com.jefflete.rickandmorty.domain.repository.EpisodeRepository
import com.jefflete.rickandmorty.domain.utils.EpisodeDomainEntityMapper
import com.jefflete.rickandmorty.domain.utils.EpisodeDtoMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class EpisodeRepositoryImpl(
    private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource
) : EpisodeRepository {
    override suspend fun getEpisode(): Flow<List<Episode>> = localDataSource.getEpisodes().map {
        EpisodeDomainEntityMapper.toDomainList(it)
    }

    override suspend fun getEpisode(id: Int): Flow<Episode> = localDataSource.getEpisode(id).map {
        EpisodeDomainEntityMapper.toDomain(it)
    }

    override suspend fun saveEpisode(episode: EpisodeEntity) = localDataSource.saveEpisode(episode)
    override suspend fun deleteEpisode(episode: EpisodeEntity) =
        localDataSource.deleteEpisode(episode)

    override suspend fun getNetworkEpisode(id: Int): Flow<Result<Episode>> = flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(EpisodeDtoMapper.toDomain(remoteDataSource.getEpisode(id))))
        } catch (e: Exception) {
            emit(Result.Error(e.toString()))
        }
    }.catch { e ->
        emit(Result.Error(e.toString()))
    }.flowOn(Dispatchers.IO)

    override suspend fun getNetworkEpisodes(): Flow<Result<List<Episode>>> = flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(EpisodeDtoMapper.toDomainList(remoteDataSource.getEpisodes().results)))
        } catch (e: Exception) {
            emit(Result.Error(e.toString()))
        }
    }.catch { e ->
        emit(Result.Error(e.toString()))
    }.flowOn(Dispatchers.IO)
}