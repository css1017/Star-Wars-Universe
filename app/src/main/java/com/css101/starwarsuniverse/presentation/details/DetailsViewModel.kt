package com.css101.starwarsuniverse.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.css101.starwarsuniverse.domain.models.Film
import com.css101.starwarsuniverse.domain.models.Person
import com.css101.starwarsuniverse.domain.usecases.GetCharacterFromServerUseCase
import com.css101.starwarsuniverse.domain.usecases.GetCharacterFromStorageUseCase
import com.css101.starwarsuniverse.domain.usecases.GetMovieByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getCharacterFromStorageUseCase: GetCharacterFromStorageUseCase,
    private val getCharacterFromServerUseCase: GetCharacterFromServerUseCase,
    private val getMovieByIdUseCase: GetMovieByIdUseCase
) : ViewModel() {

    private val _characters = MutableLiveData<List<Person>>()
    val characters: LiveData<List<Person>> = _characters

    private val _movie = MutableLiveData<Film>()
    private val movie: LiveData<Film> = _movie

    private fun getMovieDetails(movieId: Int): Film {
        val movie = getMovieByIdUseCase.execute(movieId)
        _movie.postValue(movie)
        return movie
    }

    fun getCharacters(movieId: Int) {
        _characters.value?.let { return }

        viewModelScope.launch(Dispatchers.IO) {
            val movie = movie.value ?: getMovieDetails(movieId)
            val characters = movie.characters.mapNotNull { url ->
                getCharacterFromStorageUseCase.execute(url) ?: getCharacterFromServerUseCase.execute(url)
            }
            _characters.postValue(characters)
        }
    }
}