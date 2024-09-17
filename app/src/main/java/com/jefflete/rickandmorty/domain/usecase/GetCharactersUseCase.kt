package com.jefflete.rickandmorty.domain.usecase

import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface GetCharactersUseCase {
    suspend operator fun invoke(): Flow<Result<List<Character>>>
}