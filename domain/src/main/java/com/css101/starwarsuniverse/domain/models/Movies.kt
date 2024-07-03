package com.css101.starwarsuniverse.domain.models

data class Movies(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Film>
)

data class Film(
    val title: String,
    val episodeId: Int,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val releaseDate: String,
    val characters: List<String>,
    val planets: List<String>,
    val starships: List<String>,
    val vehicles: List<String>,
    val species: List<String>,
    val created: String,
    val edited: String,
    val url: String
)