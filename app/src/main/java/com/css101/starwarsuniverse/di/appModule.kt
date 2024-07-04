package com.css101.starwarsuniverse.di

import com.css101.starwarsuniverse.presentation.details.DetailsViewModel
import com.css101.starwarsuniverse.presentation.movies.MoviesViewModel
import com.css101.starwarsuniverse.presentation.planet.PlanetViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MoviesViewModel(
            getMoviesFromServerUseCase = get(),
            getMoviesFromStorageUseCase = get(),
        )
    }
    viewModel {
        DetailsViewModel(
            getCharacterFromStorageUseCase = get(),
            getCharacterFromServerUseCase = get(),
            getMovieByIdUseCase = get()
        )
    }
    viewModel {
        PlanetViewModel(
            getPlanetFromServerUseCase = get(),
            getPlanetFromStorageUseCase = get()
        )
    }
}
