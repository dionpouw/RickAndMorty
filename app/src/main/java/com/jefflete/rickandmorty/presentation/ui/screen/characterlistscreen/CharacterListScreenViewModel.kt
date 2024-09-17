package com.jefflete.rickandmorty.presentation.ui.screen.characterlistscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Character
import com.jefflete.rickandmorty.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterListScreenViewModel(private val getCharactersUseCase: GetCharactersUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow<Result<List<Character>>>(Result.Loading)
    val uiState: StateFlow<Result<List<Character>>> = _uiState.asStateFlow()

    fun getCharacters() {
        viewModelScope.launch {
            getCharactersUseCase().collect {
                _uiState.value = it
            }
        }
    }
}