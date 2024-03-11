package com.example.rickandmortyapi.remote.source

import com.example.rickandmortyapi.domain.model.CharacterDomain

interface CharacterDataSource {

    suspend fun getAllCharacters(
        page: Int
    ): CharacterDomain
}