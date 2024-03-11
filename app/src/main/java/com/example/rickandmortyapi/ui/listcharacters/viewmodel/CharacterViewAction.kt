package com.example.rickandmortyapi.ui.listcharacters.viewmodel

sealed class CharacterViewAction {

    data object GetCharacters : CharacterViewAction()

    data object NextCharactersList: CharacterViewAction()

}