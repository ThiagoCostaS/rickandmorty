package com.example.rickandmortyapi.application

import android.app.Application
import com.example.rickandmortyapi.di.dataSourceModule
import com.example.rickandmortyapi.di.repositoryModule
import com.example.rickandmortyapi.di.retrofitModule
import com.example.rickandmortyapi.di.useCaseModule
import com.example.rickandmortyapi.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(listOf(retrofitModule, dataSourceModule, repositoryModule, useCaseModule, viewModelModule))
        }
    }
}