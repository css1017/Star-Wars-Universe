package com.css101.starwarsuniverse.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

@Entity(tableName = "movies")
data class MoviesData @JsonCreator constructor(
    @JsonProperty("count") val count: Int,
    @JsonProperty("next") val next: String?,
    @JsonProperty("previous") val previous: String?,
    @JsonProperty("results") val results: List<FilmData>
) {
    @JsonIgnore @PrimaryKey(autoGenerate = true) var id: Int = 0

    constructor(
        count: Int,
        next: String?,
        previous: String?,
        results: List<FilmData>,
        id: Int
    ) : this(count, next, previous, results) {
        this.id = id
    }
}
data class FilmData(
    @JsonProperty("title") val title: String,
    @JsonProperty("episode_id") val episodeId: Int,
    @JsonProperty("opening_crawl") val openingCrawl: String,
    @JsonProperty("director") val director: String,
    @JsonProperty("producer") val producer: String,
    @JsonProperty("release_date") val releaseDate: String,
    @JsonProperty("characters") val characters: List<String>,
    @JsonProperty("planets") val planets: List<String>,
    @JsonProperty("starships") val starships: List<String>,
    @JsonProperty("vehicles") val vehicles: List<String>,
    @JsonProperty("species") val species: List<String>,
    @JsonProperty("created") val created: String,
    @JsonProperty("edited") val edited: String,
    @PrimaryKey @JsonProperty("url") val url: String
)