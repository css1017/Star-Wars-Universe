package com.css101.starwarsuniverse.data.storage.room

import androidx.room.TypeConverter
import com.css101.starwarsuniverse.data.models.FilmData
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

class Converters {
    private val objectMapper = ObjectMapper().apply {
        findAndRegisterModules()
    }

    @TypeConverter
    fun fromString(value: String): List<String> {
        return objectMapper.readValue(value,object : TypeReference<List<String>>() {})
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return objectMapper.writeValueAsString(list)
    }
    @TypeConverter
    fun fromFilmDataList(value: List<FilmData>): String {
        return objectMapper.writeValueAsString(value)
    }

    @TypeConverter
    fun toFilmDataList(value: String): List<FilmData> {
        return objectMapper.readValue(value, object : TypeReference<List<FilmData>>() {})
    }
}