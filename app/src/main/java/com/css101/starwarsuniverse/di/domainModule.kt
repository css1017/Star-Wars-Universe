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
    factory { GetMoviesFromServerUseCase() }
    factory { GetMoviesFromStorageUseCase() }
    factory { GetMovieByIdUseCase() }
    factory { GetPlanetFromServerUseCase() }
    factory { GetPlanetFromStorageUseCase() }
    factory { GetCharacterFromStorageUseCase() }
    factory { GetCharacterFromServerUseCase() }
}