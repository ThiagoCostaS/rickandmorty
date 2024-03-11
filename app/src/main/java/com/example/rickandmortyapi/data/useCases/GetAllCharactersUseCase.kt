package com.example.rickandmortyapi.data.useCases

import com.example.rickandmortyapi.data.CharacterRepository
import com.example.rickandmortyapi.domain.model.CharacterDomain

class GetAllCharactersUseCase(private val repository: CharacterRepository) {

    suspend operator fun invoke(
        page: Int
    ): CharacterDomain =
        repository.getAllCharacters(page)
}