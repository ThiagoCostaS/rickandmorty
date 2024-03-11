package com.example.rickandmortyapi.ui.listcharacters.viewmodel

import com.example.rickandmortyapi.domain.model.CharacterDomain

sealed class CharacterViewState() {

    data object Loading: CharacterViewState()

    class ShowCharacters(val character: CharacterDomain): CharacterViewState()

    class SetNextCharacterPage(val character: CharacterDomain): CharacterViewState()

    class Error(val message: String?): CharacterViewState()
}