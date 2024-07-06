package com.css101.starwarsuniverse.data.models

import com.fasterxml.jackson.annotation.JsonProperty

data class PlanetData(
    @JsonProperty("name") val name: String,
    @JsonProperty("rotation_period") val rotationPeriod: String,
    @JsonProperty("orbital_period") val orbitalPeriod: String,
    @JsonProperty("diameter") val diameter: String,
    @JsonProperty("climate") val climate: String,
    @JsonProperty("gravity") val gravity: String,
    @JsonProperty("terrain") val terrain: String,
    @JsonProperty("surface_water") val surfaceWater: String,
    @JsonProperty("population") val population: String,
    @JsonProperty("residents") val residents: List<String>,
    @JsonProperty("films") val films: List<String>,
    @JsonProperty("created") val created: String,
    @JsonProperty("edited") val edited: String,
    @JsonProperty("url") val url: String
)