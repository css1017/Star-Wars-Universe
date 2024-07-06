package com.css101.starwarsuniverse.data.storage.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.css101.starwarsuniverse.data.models.CharacterData

@Dao
interface CharactersDao {
    @Query("SELECT * FROM characters WHERE url = :url")
    suspend fun getCharacter(url: String): CharacterData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterData)
}