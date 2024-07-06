package com.css101.starwarsuniverse.domain.usecases

import com.css101.starwarsuniverse.domain.models.Planet
import com.css101.starwarsuniverse.domain.repository.SwapiRepo

class GetPlanetFromServerUseCase (private val swapiRepo: SwapiRepo){

    suspend fun execute(planet: String): Planet? {
        return swapiRepo.getAndSavePlanet(planet)

    }
}