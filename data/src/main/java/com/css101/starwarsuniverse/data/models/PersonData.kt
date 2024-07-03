package com.css101.starwarsuniverse.data.models

import com.fasterxml.jackson.annotation.JsonProperty

data class PersonData(
    val name: String,
    val height: String,
    val mass: String,
    @JsonProperty("hair_color")
    val hairColor: String,
    @JsonProperty("skin_color")
    val skinColor: String,
    @JsonProperty("eye_color")
    val eyeColor: String,
    @JsonProperty("birth_year")
    val birthYear: String,
    val gender: String,
    @JsonProperty("homeworld")
    val homeWorld: String,
    val films: List<String>,
    val species: List<String>,
    val vehicles: List<String>,
    val starships: List<String>,
    val created: String,
    val edited: String,
    val url: String
)