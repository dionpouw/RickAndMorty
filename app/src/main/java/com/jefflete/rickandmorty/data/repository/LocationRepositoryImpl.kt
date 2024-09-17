package com.jefflete.rickandmorty.data.repository

import com.jefflete.rickandmorty.data.local.LocalDataSource
import com.jefflete.rickandmorty.data.local.model.LocationEntity
import com.jefflete.rickandmorty.data.network.RemoteDataSource
import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Location
import com.jefflete.rickandmorty.domain.repository.LocationRepository
import com.jefflete.rickandmorty.domain.utils.LocationDomainEntityMapper
import com.jefflete.rickandmorty.domain.utils.LocationDtoMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class LocationRepositoryImpl(
    private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource
) : LocationRepository {

    override suspend fun getLocations(): Flow<List<Location>> = localDataSource.getLocations().map {
        LocationDomainEntityMapper.toDomainList(it)
    }


    override suspend fun getLocation(id: Int): Flow<Location> =
        localDataSource.getLocation(id).map {
            LocationDomainEntityMapper.toDomain(it)
        }

    override suspend fun saveLocation(location: LocationEntity) =
        localDataSource.saveLocation(location)

    override suspend fun deleteLocation(location: LocationEntity) =
        localDataSource.deleteLocation(location)

    override suspend fun getNetworkLocation(id: Int): Flow<Result<Location>> = flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(LocationDtoMapper.toDomain(remoteDataSource.getLocation(id))))
        } catch (e: Exception) {
            emit(Result.Error(e.toString()))
        }
    }.catch { e ->
        emit(Result.Error(e.toString()))
    }.flowOn(Dispatchers.IO)

    override suspend fun getNetworkLocations(): Flow<Result<List<Location>>> = flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(LocationDtoMapper.toDomainList(remoteDataSource.getLocations().results)))
        } catch (e: Exception) {
            emit(Result.Error(e.toString()))
        }
    }.catch { e ->
        emit(Result.Error(e.toString()))
    }.flowOn(Dispatchers.IO)
}
