package com.css101.starwarsuniverse.data.storage.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.css101.starwarsuniverse.data.models.MoviesData

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): List<MoviesData>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MoviesData>)

}