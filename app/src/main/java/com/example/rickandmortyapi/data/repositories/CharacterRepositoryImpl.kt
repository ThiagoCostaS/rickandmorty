package com.example.rickandmortyapi.data.repositories

import com.example.rickandmortyapi.data.CharacterRepository
import com.example.rickandmortyapi.domain.model.CharacterDomain
import com.example.rickandmortyapi.remote.source.CharacterDataSource

class CharacterRepositoryImpl(private val remoteDataSource: CharacterDataSource): CharacterRepository {
    override suspend fun getAllCharacters(page: Int): CharacterDomain =
        remoteDataSource.getAllCharacters(page)
}