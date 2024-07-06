package com.css101.starwarsuniverse.domain.usecases

import com.css101.starwarsuniverse.domain.models.Film
import com.css101.starwarsuniverse.domain.repository.StorageRepo

class GetMovieByIdUseCase() {
    //private val storageRepo: StorageRepo) {
    suspend fun execute(id: Int): Film {
        return Film(
            title = "ligula",
            episodeId = 9009,
            openingCrawl = "mel",
            director = "efficiantur",
            producer = "dolorum",
            releaseDate = "malesuada",
            characters = listOf(
                "https://swapi.dev/api/people/1/",
                "https://swapi.dev/api/people/2/",
                "https://swapi.dev/api/people/3/",
                "https://swapi.dev/api/people/4/",
                "https://swapi.dev/api/people/5/",
                "https://swapi.dev/api/people/6/",
                "https://swapi.dev/api/people/7/",
                "https://swapi.dev/api/people/8/",
                "https://swapi.dev/api/people/9/",
                "https://swapi.dev/api/people/10/",
                "https://swapi.dev/api/people/12/",
                "https://swapi.dev/api/people/13/",
                "https://swapi.dev/api/people/14/",
                "https://swapi.dev/api/people/15/",
                "https://swapi.dev/api/people/16/",
                "https://swapi.dev/api/people/18/",
                "https://swapi.dev/api/people/19/",
                "https://swapi.dev/api/people/81/"
            ),
            planets = listOf(),
            starships = listOf(),
            vehicles = listOf(),
            species = listOf(),
            created = "partiendo",
            edited = "nostra",
            url = "https://search.yahoo.com/search?p=vero"
        )//storageRepo.getMovieById(id)
    }
}