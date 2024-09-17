package com.jefflete.rickandmorty.domain.repository

import com.jefflete.rickandmorty.data.local.model.LocationEntity
import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    suspend fun getLocations(): Flow<List<Location>>
    suspend fun getLocation(id: Int): Flow<Location>
    suspend fun saveLocation(location: LocationEntity)
    suspend fun deleteLocation(location: LocationEntity)
    suspend fun getNetworkLocation(id: Int): Flow<Result<Location>>
    suspend fun getNetworkLocations(): Flow<Result<List<Location>>>
}