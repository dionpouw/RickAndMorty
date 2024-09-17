package com.jefflete.rickandmorty.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jefflete.rickandmorty.data.local.dao.CharacterDao
import com.jefflete.rickandmorty.data.local.dao.EpisodeDao
import com.jefflete.rickandmorty.data.local.dao.LocationDao
import com.jefflete.rickandmorty.data.local.db.converter.CharacterEpisodeTypeConverter
import com.jefflete.rickandmorty.data.local.db.converter.CharacterLocationTypeConverter
import com.jefflete.rickandmorty.data.local.db.converter.CharacterOriginTypeConverter
import com.jefflete.rickandmorty.data.local.model.CharacterEntity
import com.jefflete.rickandmorty.data.local.model.EpisodeEntity
import com.jefflete.rickandmorty.data.local.model.LocationEntity

@Database(
    entities = [CharacterEntity::class, EpisodeEntity::class, LocationEntity::class], version = 1
)
@TypeConverters(
    CharacterOriginTypeConverter::class,
    CharacterLocationTypeConverter::class,
    CharacterEpisodeTypeConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
}