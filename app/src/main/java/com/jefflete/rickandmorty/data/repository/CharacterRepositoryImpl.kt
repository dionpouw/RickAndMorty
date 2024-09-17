package com.jefflete.rickandmorty.data.repository

import com.jefflete.rickandmorty.data.local.LocalDataSource
import com.jefflete.rickandmorty.data.local.model.CharacterEntity
import com.jefflete.rickandmorty.data.network.RemoteDataSource
import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Character
import com.jefflete.rickandmorty.domain.repository.CharacterRepository
import com.jefflete.rickandmorty.domain.utils.CharacterDomainEntityMapper
import com.jefflete.rickandmorty.domain.utils.CharacterDtoMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class CharacterRepositoryImpl(
    private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource
) : CharacterRepository {
    override suspend fun getCharacters(): Flow<List<Character>> =
        localDataSource.getCharacters().map {
            CharacterDomainEntityMapper.toDomainList(it)
        }

    override suspend fun getCharacter(id: Int): Flow<Character> =
        localDataSource.getCharacter(id).map {
            CharacterDomainEntityMapper.toDomain(it)
        }

    override suspend fun saveCharacter(character: CharacterEntity) =
        localDataSource.saveCharacter(character)

    override suspend fun deleteCharacter(character: CharacterEntity) =
        localDataSource.deleteCharacter(character)

    override suspend fun getNetworkCharacter(id: Int): Flow<Result<Character>> = flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(CharacterDtoMapper.toDomain(remoteDataSource.getCharacter(id))))
        } catch (e: Exception) {
            emit(Result.Error(e.toString()))
        }
    }.catch { e ->
        emit(Result.Error(e.toString()))
    }.flowOn(Dispatchers.IO)

    override suspend fun getNetworkCharacters(): Flow<Result<List<Character>>> = flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(CharacterDtoMapper.toDomainList(remoteDataSource.getCharacters().results)))
        } catch (e: Exception) {
            emit(Result.Error(e.toString()))
        }
    }.catch { e ->
        emit(Result.Error(e.toString()))
    }.flowOn(Dispatchers.IO)

}
