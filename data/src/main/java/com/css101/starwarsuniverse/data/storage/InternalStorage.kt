package com.css101.starwarsuniverse.data.storage

import com.css101.starwarsuniverse.data.models.CharacterData
import com.css101.starwarsuniverse.data.models.MoviesData
import com.css101.starwarsuniverse.data.models.PlanetData

interface InternalStorage {
    suspend fun getMoviesFromStorage(): MoviesData?
    suspend fun saveMoviesToStorage(movies: MoviesData)
    suspend fun getCharacterFromStorage(character: String): CharacterData?
    suspend fun saveCharacterToStorage(character: CharacterData)
    suspend fun getPlanetFromStorage(planet: String): PlanetData?
    suspend fun savePlanetToStorage(planet: PlanetData)
}