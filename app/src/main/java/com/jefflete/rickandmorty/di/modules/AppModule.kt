package com.jefflete.rickandmorty.di.modules

import com.jefflete.rickandmorty.data.local.LocalDataSource
import com.jefflete.rickandmorty.data.local.LocalDataSourceImpl
import com.jefflete.rickandmorty.data.network.RemoteDataSource
import com.jefflete.rickandmorty.data.network.RemoteDataSourceImpl
import com.jefflete.rickandmorty.data.repository.CharacterRepositoryImpl
import com.jefflete.rickandmorty.domain.repository.CharacterRepository
import com.jefflete.rickandmorty.domain.usecase.GetCharactersUseCase
import com.jefflete.rickandmorty.domain.usecase.GetCharactersUseCaseImpl
import com.jefflete.rickandmorty.presentation.ui.screen.characterlistscreen.CharacterListScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get()) }
    factory<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    factory<GetCharactersUseCase> { GetCharactersUseCaseImpl(get()) }
    factory<LocalDataSource> { LocalDataSourceImpl(get()) }
    viewModel { CharacterListScreenViewModel(get()) }
}