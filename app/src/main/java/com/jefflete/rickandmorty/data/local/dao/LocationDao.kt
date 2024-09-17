package com.jefflete.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jefflete.rickandmorty.data.local.model.LocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    @Query("SELECT * FROM locationentity WHERE id = :id")
    fun getLocation(id: Int): Flow<LocationEntity>

    @Query("SELECT * FROM locationentity")
    fun getLocations(): Flow<List<LocationEntity>>

    @Insert
    suspend fun insertLocation(location: LocationEntity)

    @Delete
    suspend fun deleteLocation(location: LocationEntity)
}