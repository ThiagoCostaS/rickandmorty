package com.example.rickandmortyapi.di

import com.example.rickandmortyapi.data.CharacterRepository
import com.example.rickandmortyapi.data.repositories.CharacterRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
}