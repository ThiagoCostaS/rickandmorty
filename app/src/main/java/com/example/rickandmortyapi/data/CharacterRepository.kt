package com.example.rickandmortyapi.data

import com.example.rickandmortyapi.domain.model.CharacterDomain

interface CharacterRepository {

    suspend fun getAllCharacters(page: Int): CharacterDomain
}