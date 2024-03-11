package com.example.rickandmortyapi.remote.model

data class Character(
    val info: Info,
    val results: List<Result>
)