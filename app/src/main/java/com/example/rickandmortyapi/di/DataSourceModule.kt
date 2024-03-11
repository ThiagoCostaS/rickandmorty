package com.example.rickandmortyapi.di

import com.example.rickandmortyapi.remote.network.repository.CharacterDataSourceImpl
import com.example.rickandmortyapi.remote.source.CharacterDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<CharacterDataSource> { CharacterDataSourceImpl(get()) }
}