package com.jefflete.rickandmorty.data.repository

import com.jefflete.rickandmorty.data.local.LocalDataSource
import com.jefflete.rickandmorty.data.network.RemoteDataSource
import com.jefflete.rickandmorty.domain.repository.EpisodeRepository

class EpisodeRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : EpisodeRepository {

}