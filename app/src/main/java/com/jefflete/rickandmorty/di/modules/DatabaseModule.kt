package com.jefflete.rickandmorty.di.modules

import androidx.room.Room
import com.jefflete.rickandmorty.data.local.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<AppDatabase>().characterDao() }
    factory { get<AppDatabase>().locationDao() }
    factory { get<AppDatabase>().episodeDao() }
    single {
        Room.databaseBuilder(
            androidContext(), AppDatabase::class.java, "Product.db"
        ).fallbackToDestructiveMigration().build()
    }
}