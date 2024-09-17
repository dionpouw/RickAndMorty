package com.jefflete.rickandmorty.domain.usecase

import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Character
import com.jefflete.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class GetCharactersUseCaseImpl(private val characterRepository: CharacterRepository) :
    GetCharactersUseCase {
    override suspend fun invoke(): Flow<Result<List<Character>>> =
        characterRepository.getNetworkCharacters()
            .flowOn(Dispatchers.IO)
            .catch { e -> emit(Result.Error(e.toString())) }
}