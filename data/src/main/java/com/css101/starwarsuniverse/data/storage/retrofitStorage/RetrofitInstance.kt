package com.css101.starwarsuniverse.data.storage.retrofitStorage

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object RetrofitInstance {
    private val objectMapper = ObjectMapper().apply {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://swapi.dev")
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .build()
    }
    val starWarsService: StarWarsService = retrofit.create(StarWarsService::class.java)
}