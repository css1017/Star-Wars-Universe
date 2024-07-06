package com.css101.starwarsuniverse.data.repository

import com.css101.starwarsuniverse.data.models.CharacterData
import com.css101.starwarsuniverse.data.models.FilmData
import com.css101.starwarsuniverse.data.models.MoviesData
import com.css101.starwarsuniverse.data.models.PlanetData
import com.css101.starwarsuniverse.data.storage.InternalStorage
import com.css101.starwarsuniverse.domain.models.Character
import com.css101.starwarsuniverse.domain.models.Film
import com.css101.starwarsuniverse.domain.models.Movies
import com.css101.starwarsuniverse.domain.models.Planet
import com.css101.starwarsuniverse.domain.repository.StorageRepo

class StorageRepoImpl(private val internalStorage: InternalStorage): StorageRepo {
    override suspend fun getMoviesFromStorage(): Movies? {
        return dataToMovie(internalStorage.getMoviesFromStorage())
    }

    override suspend fun saveMoviesToStorage(movies: Movies) {
        internalStorage.saveMoviesToStorage(movieToData(movies))
    }

    override suspend fun getCharacterFromStorage(character: String): Character? {
        return dataToCharacter(internalStorage.getCharacterFromStorage(character))
    }
    override suspend fun saveCharacterToStorage(character: Character) {
        internalStorage.saveCharacterToStorage(characterToData(character))
    }

    override suspend fun getPlanetFromStorage(planet: String): Planet? {
        return dataToPlanet(internalStorage.getPlanetFromStorage(planet))
    }
    override suspend fun savePlanetToStorage(planet: Planet) {
        internalStorage.savePlanetToStorage(planetToData(planet))
    }

    private fun movieToData(movie: Movies) = MoviesData(
        id = 0,
        count = movie.count,
        next = movie.next,
        previous = movie.previous,
        results = movie.results.map { filmToData(it) }
    )

    private fun filmToData(film: Film) = FilmData(
        title = film.title,
        episodeId = film.episodeId,
        openingCrawl = film.openingCrawl,
        director = film.director,
        producer = film.producer,
        releaseDate = film.releaseDate,
        characters = film.characters,
        planets = film.planets,
        starships = film.starships,
        vehicles = film.vehicles,
        species = film.species,
        created = film.created,
        edited = film.edited,
        url = film.url
    )


    private fun characterToData(character: Character): CharacterData {
        return CharacterData(
            name = character.name,
            height = character.height,
            mass = character.mass,
            hairColor = character.hairColor,
            skinColor = character.skinColor,
            eyeColor = character.eyeColor,
            birthYear = character.birthYear,
            gender = character.gender,
            homeWorld = character.homeWorld,
            films = character.films,
            species = character.species,
            vehicles = character.vehicles,
            starships = character.starships,
            created = character.created,
            edited = character.edited,
            url = character.url
        )
    }

    private fun planetToData(planet: Planet): PlanetData {
        return PlanetData(
            name = planet.name,
            rotationPeriod = planet.rotationPeriod,
            orbitalPeriod = planet.orbitalPeriod,
            diameter = planet.diameter,
            climate = planet.climate,
            gravity = planet.gravity,
            terrain = planet.terrain,
            surfaceWater = planet.surfaceWater,
            population = planet.population,
            residents = planet.residents,
            films = planet.films,
            created = planet.created,
            edited = planet.edited,
            url = planet.url
        )
    }

    private fun dataToMovie(data: MoviesData?): Movies? {
        return if (data == null) null else Movies(
            count = data.count,
            next = data.next,
            previous = data.previous,
            results = data.results.map { dataToFilm(it) }
        )
    }

    private fun dataToFilm(data: FilmData) = Film(
        title = data.title,
        episodeId = data.episodeId,
        openingCrawl = data.openingCrawl,
        director = data.director,
        producer = data.producer,
        releaseDate = data.releaseDate,
        characters = data.characters,
        planets = data.planets,
        starships = data.starships,
        vehicles = data.vehicles,
        species = data.species,
        created = data.created,
        edited = data.edited,
        url = data.url
    )




    private fun dataToCharacter(character: CharacterData?): Character? {
        return if (character == null) null else Character(
            name = character.name,
            height = character.height,
            mass = character.mass,
            hairColor = character.hairColor,
            skinColor = character.skinColor,
            eyeColor = character.eyeColor,
            birthYear = character.birthYear,
            gender = character.gender,
            homeWorld = character.homeWorld,
            films = character.films,
            species = character.species,
            vehicles = character.vehicles,
            starships = character.starships,
            created = character.created,
            edited = character.edited,
            url = character.url
        )
    }


    private fun dataToPlanet(planet: PlanetData?): Planet? {
        return if (planet == null) null else Planet(
            name = planet.name,
            rotationPeriod = planet.rotationPeriod,
            orbitalPeriod = planet.orbitalPeriod,
            diameter = planet.diameter,
            climate = planet.climate,
            gravity = planet.gravity,
            terrain = planet.terrain,
            surfaceWater = planet.surfaceWater,
            population = planet.population,
            residents = planet.residents,
            films = planet.films,
            created = planet.created,
            edited = planet.edited,
            url = planet.url
        )
    }
}