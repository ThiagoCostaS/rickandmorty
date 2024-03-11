package com.example.rickandmortyapi.ui.listcharacters.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.core.runCatching
import com.example.rickandmortyapi.data.useCases.GetAllCharactersUseCase
import com.example.rickandmortyapi.domain.model.CharacterDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val getAllCharacters: GetAllCharactersUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _viewState = MutableLiveData<CharacterViewState?>()
    val viewState: LiveData<CharacterViewState?> = _viewState

    private var currentPage = 1
    private var pages: Int? = null

    fun dispatchAction(action: CharacterViewAction) {
        when (action) {
            CharacterViewAction.GetCharacters -> {
                loadAllCharacters()
            }

            CharacterViewAction.NextCharactersList -> {
                loadAllCharacters(isFirstPage = false)
            }
        }
    }

    private fun loadAllCharacters(isFirstPage: Boolean = true) = viewModelScope.launch(dispatcher) {

        _viewState.postValue(CharacterViewState.Loading)

        runCatching(
            dispatcher = Dispatchers.Default,
            execute = {
                getAllCharacters(currentPage)
            },
            onFailure = {
                _viewState.postValue(CharacterViewState.Error(it.message))
            },
            onSuccess = {
                if (isFirstPage) {
                    _viewState.postValue(CharacterViewState.ShowCharacters(it))
                } else {
                    _viewState.postValue(CharacterViewState.SetNextCharacterPage(it))
                }
                resolveNextPage(it)
            }
        )
    }

    private fun resolveNextPage(it: CharacterDomain) {
        pages = it.info.pages
        if (currentPage < it.info.pages) {
            currentPage = (it.info.next?.last().toString().toDoubleOrNull() ?: 1).toInt()
        }
    }
}
