package com.css101.starwarsuniverse.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonProperty

@Entity(tableName = "characters")
data class CharacterData(

    @JsonProperty("name") val name: String,
    @JsonProperty("height") val height: String,
    @JsonProperty("mass") val mass: String,
    @JsonProperty("hair_color") val hairColor: String,
    @JsonProperty("skin_color") val skinColor: String,
    @JsonProperty("eye_color") val eyeColor: String,
    @JsonProperty("birth_year") val birthYear: String,
    @JsonProperty("gender") val gender: String,
    @JsonProperty("homeworld") val homeWorld: String,
    @JsonProperty("films") val films: List<String>,
    @JsonProperty("species") val species: List<String>,
    @JsonProperty("vehicles") val vehicles: List<String>,
    @JsonProperty("starships") val starships: List<String>,
    @JsonProperty("created") val created: String,
    @JsonProperty("edited") val edited: String,
    @PrimaryKey @JsonProperty("url") val url: String
)