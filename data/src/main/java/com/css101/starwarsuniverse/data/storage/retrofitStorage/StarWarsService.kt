package com.css101.starwarsuniverse.data.storage.retrofitStorage


import com.css101.starwarsuniverse.data.models.CharacterData
import com.css101.starwarsuniverse.data.models.MoviesData
import com.css101.starwarsuniverse.data.models.PlanetData
import retrofit2.http.GET
import retrofit2.http.Url

interface StarWarsService {
    @GET("/api/films/")
    suspend fun getFilms(): MoviesData
    @GET
    suspend fun getCharacter(@Url characterUrl: String): CharacterData
    @GET
    suspend fun getPlanet(@Url planetUrl: String): PlanetData
}