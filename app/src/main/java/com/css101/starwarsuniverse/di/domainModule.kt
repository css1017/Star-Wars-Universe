package com.css101.starwarsuniverse.di

import com.css101.starwarsuniverse.domain.usecases.GetMoviesFromServerUseCase
import com.css101.starwarsuniverse.domain.usecases.GetMoviesFromStorageUseCase
import com.css101.starwarsuniverse.domain.usecases.SaveMoviesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetMoviesFromServerUseCase() }
    factory { GetMoviesFromStorageUseCase() }
    factory { SaveMoviesUseCase() }
}