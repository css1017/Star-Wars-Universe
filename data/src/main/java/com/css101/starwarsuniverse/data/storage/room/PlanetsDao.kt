package com.css101.starwarsuniverse.data.storage.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.css101.starwarsuniverse.data.models.PlanetData

@Dao
interface PlanetsDao {
    @Query("SELECT * FROM planets WHERE url = :url")
    suspend fun getPlanet(url: String): PlanetData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanet(planet: PlanetData)
}