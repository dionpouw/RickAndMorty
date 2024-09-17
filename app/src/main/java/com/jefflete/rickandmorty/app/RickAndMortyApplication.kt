package com.jefflete.rickandmorty.app

import android.app.Application
import com.jefflete.rickandmorty.di.modules.appModule
import com.jefflete.rickandmorty.di.modules.databaseModule
import com.jefflete.rickandmorty.di.modules.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApplication)
            modules(networkModule, appModule, databaseModule)
        }
    }

}