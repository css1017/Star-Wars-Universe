package com.css101.starwarsuniverse.domain.usecases

import com.css101.starwarsuniverse.domain.models.Planet
import com.css101.starwarsuniverse.domain.repository.StorageRepo

class GetPlanetFromStorageUseCase(){//private val storageRepo: StorageRepo) {

    suspend fun execute(planet: String): Planet? {
        return null //storageRepo.getPlanetFromStorage(planet)
    }
}