package com.css101.starwarsuniverse.domain.repository

import com.css101.starwarsuniverse.domain.models.Character
import com.css101.starwarsuniverse.domain.models.Film
import com.css101.starwarsuniverse.domain.models.Movies
import com.css101.starwarsuniverse.domain.models.Planet

interface StorageRepo {
    suspend fun saveMoviesToStorage(movies: Movies)
    suspend fun saveCharacterToStorage(character: Character)
    suspend fun savePlanetToStorage(planet: Planet)
    suspend fun getMoviesFromStorage(): Movies?
    suspend fun getCharacterFromStorage(character: String): Character?
    suspend fun getPlanetFromStorage(planet: String): Planet?
    suspend fun getMovieById(id: Int): Film

}