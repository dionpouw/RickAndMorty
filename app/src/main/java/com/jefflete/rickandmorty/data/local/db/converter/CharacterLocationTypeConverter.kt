package com.jefflete.rickandmorty.data.local.db.converter

import androidx.room.TypeConverter
import com.jefflete.rickandmorty.data.local.model.CharacterLocationEntity

class CharacterLocationTypeConverter {
    @TypeConverter
    fun fromCharacterOriginEntity(origin: CharacterLocationEntity): String {
        return origin.let { "${it.name},${it.url}" }
    }

    @TypeConverter
    fun toCharacterOriginEntity(data: String): CharacterLocationEntity {
        return data.split(",").let {
            CharacterLocationEntity(it[0], it[1])
        }
    }
}