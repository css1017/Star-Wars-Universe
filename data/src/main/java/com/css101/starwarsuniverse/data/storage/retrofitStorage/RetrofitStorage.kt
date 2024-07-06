package com.css101.starwarsuniverse.data.storage.retrofitStorage

import com.css101.starwarsuniverse.data.models.CharacterData
import com.css101.starwarsuniverse.data.models.MoviesData
import com.css101.starwarsuniverse.data.models.PlanetData
import com.css101.starwarsuniverse.data.storage.ExternalStorage

class RetrofitStorage : ExternalStorage {

    override suspend fun getMoviesFromServer(): MoviesData? {
        return try {
            RetrofitInstance.starWarsService.getFilms()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getCharacterFromServer(character: String): CharacterData? {
        return try {
            RetrofitInstance.starWarsService.getCharacter(character)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getPlanetFromServer(planet: String): PlanetData? {
        return try {
            RetrofitInstance.starWarsService.getPlanet(planet)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}