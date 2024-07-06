package com.css101.starwarsuniverse.domain.usecases

import com.css101.starwarsuniverse.domain.models.Film
import com.css101.starwarsuniverse.domain.repository.StorageRepo

class GetMovieByIdUseCase(private val storageRepo: StorageRepo) {
    suspend fun execute(url: String): Film? {
        return storageRepo.getMoviesFromStorage()?.results?.firstOrNull { it.url == url }
    }
}