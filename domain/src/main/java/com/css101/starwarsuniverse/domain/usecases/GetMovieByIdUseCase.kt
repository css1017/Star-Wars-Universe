package com.css101.starwarsuniverse.domain.usecases

import com.css101.starwarsuniverse.domain.models.Film

class GetMovieByIdUseCase {
    fun execute(id: Int): Film {
        return Film(
            title = "veniam",
            episodeId = 4414,
            openingCrawl = "sonet",
            director = "integer",
            producer = "delicata",
            releaseDate = "placerat",
            characters = listOf("1", "2", "3", "4", "5", "6", "7", "818", "19", "20"),
            planets = listOf(),
            starships = listOf(),
            vehicles = listOf(),
            species = listOf(),
            created = "qui",
            edited = "suscipiantur",
            url = "https://search.yahoo.com/search?p=ferri"
        )
    }
}