package com.example.rickandmortyapi.domain.model

data class InfoDomain(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)
