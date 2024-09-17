package com.jefflete.rickandmorty.data.local.db.converter

import androidx.room.TypeConverter
import com.jefflete.rickandmorty.data.local.model.CharacterOriginEntity

class CharacterOriginTypeConverter {

    @TypeConverter
    fun fromCharacterOriginEntity(origin: CharacterOriginEntity): String {
        return origin.let { "${it.name},${it.url}" }
    }

    @TypeConverter
    fun toCharacterOriginEntity(data: String): CharacterOriginEntity {
        return data.split(",").let {
            CharacterOriginEntity(it[0], it[1])
        }
    }
}
