package com.jefflete.rickandmorty.data.local.db.converter

import androidx.room.TypeConverter

class CharacterEpisodeTypeConverter {
    @TypeConverter
    fun fromStringList(list: List<String>): String? {
        return list.joinToString(",")
    }

    @TypeConverter
    fun toStringList(data: String): List<String> {
        return data.split(",").filter { it.isNotEmpty() }
    }
}