package com.css101.starwarsuniverse.domain.usecases

import com.css101.starwarsuniverse.domain.models.Film
import com.css101.starwarsuniverse.domain.repository.SwapiRepo

class GetMoviesFromServerUseCase(private val swapiRepo: SwapiRepo) {

    suspend fun execute(): List<Film>? {
        return swapiRepo.getAndSaveMovies()?.results
    }
}