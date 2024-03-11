package com.example.rickandmortyapi.remote.network

import com.example.rickandmortyapi.remote.model.Character
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): Character
}