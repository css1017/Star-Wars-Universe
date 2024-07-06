package com.css101.starwarsuniverse.data.storage

import com.css101.starwarsuniverse.data.models.CharacterData
import com.css101.starwarsuniverse.data.models.MoviesData
import com.css101.starwarsuniverse.data.models.PlanetData

interface ExternalStorage {
    suspend fun getMoviesFromServer(): MoviesData?
    suspend fun getCharacterFromServer(character: String): CharacterData?
    suspend fun getPlanetFromServer(planet: String): PlanetData?

}