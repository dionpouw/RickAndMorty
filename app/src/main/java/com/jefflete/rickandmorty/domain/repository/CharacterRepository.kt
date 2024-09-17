package com.jefflete.rickandmorty.domain.repository

import com.jefflete.rickandmorty.data.local.model.CharacterEntity
import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(): Flow<List<Character>>
    suspend fun getCharacter(id: Int): Flow<Character>
    suspend fun saveCharacter(character: CharacterEntity)
    suspend fun deleteCharacter(character: CharacterEntity)
    suspend fun getNetworkCharacter(id: Int): Flow<Result<Character>>
    suspend fun getNetworkCharacters(): Flow<Result<List<Character>>>
}