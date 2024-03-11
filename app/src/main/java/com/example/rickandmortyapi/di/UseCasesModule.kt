package com.example.rickandmortyapi.di

import com.example.rickandmortyapi.data.useCases.GetAllCharactersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetAllCharactersUseCase(get()) }
}