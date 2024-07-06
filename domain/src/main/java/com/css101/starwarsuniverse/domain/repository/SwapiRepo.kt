package com.css101.starwarsuniverse.domain.repository

import com.css101.starwarsuniverse.domain.models.Character
import com.css101.starwarsuniverse.domain.models.Movies
import com.css101.starwarsuniverse.domain.models.Planet

interface SwapiRepo {
    suspend fun getAndSaveMovies(): Movies?
    suspend fun getAndSaveCharacter(character: String): Character?
    suspend fun getAndSavePlanet(planet: String): Planet?
}