package com.example.rickandmortyapi.di

import com.example.rickandmortyapi.remote.network.ApiService
import com.example.rickandmortyapi.remote.network.CharacterService
import org.koin.dsl.module
import retrofit2.Retrofit

val retrofitModule = module {
    single { ApiService.initRetrofit() }
    single { get<Retrofit>().create(CharacterService::class.java) }
}