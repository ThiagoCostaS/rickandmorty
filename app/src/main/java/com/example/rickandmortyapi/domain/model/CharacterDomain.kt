package com.example.rickandmortyapi.domain.model



data class CharacterDomain(
    val info: InfoDomain,
    val results: List<ResultDomain>
)
