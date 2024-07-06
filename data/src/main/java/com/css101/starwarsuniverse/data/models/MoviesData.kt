package com.css101.starwarsuniverse.data.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MoviesData(
    @JsonProperty("count")
    val count: Int,
    @JsonProperty("next")
    val next: String?,
    @JsonProperty("previous")
    val previous: String?,
    @JsonProperty("results")
    val results: List<FilmData>
)

data class FilmData(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("episode_id")
    val episodeId: Int,
    @JsonProperty("opening_crawl")
    val openingCrawl: String,
    @JsonProperty("director")
    val director: String,
    @JsonProperty("producer")
    val producer: String,
    @JsonProperty("release_date")
    val releaseDate: String,
    @JsonProperty("characters")
    val characters: List<String>,
    @JsonProperty("planets")
    val planets: List<String>,
    @JsonProperty("starships")
    val starships: List<String>,
    @JsonProperty("vehicles")
    val vehicles: List<String>,
    @JsonProperty("species")
    val species: List<String>,
    @JsonProperty("created")
    val created: String,
    @JsonProperty("edited")
    val edited: String,
    @JsonProperty("url")
    val url: String
)