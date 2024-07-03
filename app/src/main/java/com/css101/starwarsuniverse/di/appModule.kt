package com.css101.starwarsuniverse.di

import com.css101.starwarsuniverse.presentation.movies.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MoviesViewModel()
    }

}
