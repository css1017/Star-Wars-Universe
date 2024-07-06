package com.css101.starwarsuniverse.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.css101.starwarsuniverse.domain.models.Film
import com.css101.starwarsuniverse.domain.models.Character
import com.css101.starwarsuniverse.domain.usecases.GetCharacterFromServerUseCase
import com.css101.starwarsuniverse.domain.usecases.GetCharacterFromStorageUseCase
import com.css101.starwarsuniverse.domain.usecases.GetMovieByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getCharacterFromStorageUseCase: GetCharacterFromStorageUseCase,
    private val getCharacterFromServerUseCase: GetCharacterFromServerUseCase,
    private val getMovieByIdUseCase: GetMovieByIdUseCase
) : ViewModel() {

    private val _characters = MutableLiveData<List<Character>?>()
    val characters: LiveData<List<Character>?> = _characters

    private val _movie = MutableLiveData<Film?>()
    val movie: LiveData<Film?> = _movie

    private suspend fun getMovieDetails(url: String): Film? {
        val movie = getMovieByIdUseCase.execute(url)
        _movie.postValue(movie)
        return movie
    }

    fun getCharacters(url: String) {
        _characters.value?.let { return }

        viewModelScope.launch(Dispatchers.IO) {
            val movie = movie.value ?: getMovieDetails(url)
            val characterDeferred = movie?.characters?.map { url ->
                async {
                    getCharacterFromStorageUseCase.execute(url) ?: getCharacterFromServerUseCase.execute(url)
                }
            }
            val characters = characterDeferred?.mapNotNull { it.await() }
            _characters.postValue(characters)
        }
    }
}