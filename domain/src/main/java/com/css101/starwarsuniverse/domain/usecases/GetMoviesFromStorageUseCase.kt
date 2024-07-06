package com.css101.starwarsuniverse.domain.usecases

import com.css101.starwarsuniverse.domain.models.Film
import com.css101.starwarsuniverse.domain.repository.StorageRepo

class GetMoviesFromStorageUseCase(){//private val storageRepo: StorageRepo) {

    suspend fun execute(): List<Film>? {
       return null //storageRepo.getMoviesFromStorage()?.results
    }
}