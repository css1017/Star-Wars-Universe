package com.css101.starwarsuniverse.data.storage.room

import android.content.Context
import androidx.room.Room
import com.css101.starwarsuniverse.data.models.CharacterData
import com.css101.starwarsuniverse.data.models.FilmData
import com.css101.starwarsuniverse.data.models.MoviesData
import com.css101.starwarsuniverse.data.models.PlanetData
import com.css101.starwarsuniverse.data.storage.InternalStorage

class RoomStorage(context: Context) : InternalStorage {

    private val db = Room.databaseBuilder(context, AppDatabase::class.java, "ggs")
        .fallbackToDestructiveMigration()
        .build()

    override suspend fun getMoviesFromStorage(): MoviesData? {
        return db.movieDao().getAllMovies()?.firstOrNull()
    }

    override suspend fun saveMoviesToStorage(movies: MoviesData) {
        db.movieDao().insertMovies(listOf(movies))
    }

    override suspend fun getCharacterFromStorage(character: String): CharacterData? {
        return db.characterDao().getCharacter(character)
    }

    override suspend fun saveCharacterToStorage(character: CharacterData) {
        db.characterDao().insertCharacter(character)
    }

    override suspend fun getPlanetFromStorage(planet: String): PlanetData? {
        return db.planetDao().getPlanet(planet)
    }

    override suspend fun savePlanetToStorage(planet: PlanetData) {
        db.planetDao().insertPlanet(planet)
    }
}