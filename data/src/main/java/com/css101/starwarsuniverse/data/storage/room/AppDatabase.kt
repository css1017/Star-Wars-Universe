package com.css101.starwarsuniverse.data.storage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.css101.starwarsuniverse.data.models.CharacterData
import com.css101.starwarsuniverse.data.models.MoviesData
import com.css101.starwarsuniverse.data.models.PlanetData

@Database(entities = [MoviesData::class, CharacterData::class, PlanetData::class], version = 3)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MoviesDao
    abstract fun characterDao(): CharactersDao
    abstract fun planetDao(): PlanetsDao
}