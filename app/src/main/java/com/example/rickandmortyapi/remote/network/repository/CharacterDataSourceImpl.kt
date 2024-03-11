package com.example.rickandmortyapi.remote.network.repository

import com.example.rickandmortyapi.domain.mapper.toDomain
import com.example.rickandmortyapi.domain.model.CharacterDomain
import com.example.rickandmortyapi.extensions.getOrThrowDomainError
import com.example.rickandmortyapi.remote.network.CharacterService
import com.example.rickandmortyapi.remote.source.CharacterDataSource

class CharacterDataSourceImpl(private val service: CharacterService) : CharacterDataSource {

    override suspend fun getAllCharacters(page: Int): CharacterDomain {
        return runCatching { service.getAllCharacters(page) }
            .getOrThrowDomainError()
            .toDomain()
    }
}