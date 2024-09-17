package com.jefflete.rickandmorty.domain.usecase

import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface GetCharacterUseCase {
    suspend fun invoke(id: Int): Flow<Result<Character>>
}