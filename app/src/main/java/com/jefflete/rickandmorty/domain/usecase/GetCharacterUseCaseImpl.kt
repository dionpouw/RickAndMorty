package com.jefflete.rickandmorty.domain.usecase

import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Character
import com.jefflete.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class GetCharacterUseCaseImpl(private val characterRepository: CharacterRepository) :
    GetCharacterUseCase {
    override suspend fun invoke(id: Int): Flow<Result<Character>> =
        characterRepository.getNetworkCharacter(id).flowOn(Dispatchers.IO)
            .catch { e -> emit(Result.Error(e.toString())) }
}