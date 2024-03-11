package com.example.rickandmortyapi.di

import com.example.rickandmortyapi.ui.listcharacters.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CharacterViewModel(get())
    }
}