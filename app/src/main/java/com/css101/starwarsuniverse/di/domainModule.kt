package com.css101.starwarsuniverse.di

import com.css101.starwarsuniverse.domain.usecases.GetCharacterFromServerUseCase
import com.css101.starwarsuniverse.domain.usecases.GetCharacterFromStorageUseCase
import com.css101.starwarsuniverse.domain.usecases.GetMovieByIdUseCase
import com.css101.starwarsuniverse.domain.usecases.GetMoviesFromServerUseCase
import com.css101.starwarsuniverse.domain.usecases.GetMoviesFromStorageUseCase
import com.css101.starwarsuniverse.domain.usecases.GetPlanetFromServerUseCase
import com.css101.starwarsuniverse.domain.usecases.GetPlanetFromStorageUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetMoviesFromServerUseCase(swapiRepo = get()) }
    factory { GetMoviesFromStorageUseCase() }  //storageRepo = get()
    factory { GetMovieByIdUseCase() } //storageRepo = get()
    factory { GetPlanetFromServerUseCase(swapiRepo = get()) }
    factory { GetPlanetFromStorageUseCase() } //storageRepo = get()
    factory { GetCharacterFromStorageUseCase() } //storageRepo = get()
    factory { GetCharacterFromServerUseCase(swapiRepo = get()) }
}