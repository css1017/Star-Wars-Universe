package com.css101.starwarsuniverse.data.repository

import com.css101.starwarsuniverse.data.models.CharacterData
import com.css101.starwarsuniverse.data.models.FilmData
import com.css101.starwarsuniverse.data.models.MoviesData
import com.css101.starwarsuniverse.data.models.PlanetData
import com.css101.starwarsuniverse.data.storage.ExternalStorage
import com.css101.starwarsuniverse.data.storage.InternalStorage
import com.css101.starwarsuniverse.domain.models.Character
import com.css101.starwarsuniverse.domain.models.Film
import com.css101.starwarsuniverse.domain.models.Movies
import com.css101.starwarsuniverse.domain.models.Planet
import com.css101.starwarsuniverse.domain.repository.SwapiRepo

class SwapiRepoImpl(
    private val externalStorage: ExternalStorage,
    private val internalStorage: InternalStorage
) : SwapiRepo {

    override suspend fun getAndSaveMovies(): Movies? {
        val data = externalStorage.getMoviesFromServer()
        if (data != null) internalStorage.saveMoviesToStorage(data)
        return dataToMovie(data)
    }

    override suspend fun getAndSaveCharacter(character: String): Character? {
        val data = externalStorage.getCharacterFromServer(character)
        if (data != null) internalStorage.saveCharacterToStorage(data)
        return dataToCharacter(data)
    }

    override suspend fun getAndSavePlanet(planet: String): Planet? {
        val data = externalStorage.getPlanetFromServer(planet)
        if (data != null) internalStorage.savePlanetToStorage(data)
        return dataToPlanet(data)
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