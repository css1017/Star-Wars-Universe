package com.css101.starwarsuniverse.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.css101.starwarsuniverse.domain.models.Film
import com.css101.starwarsuniverse.domain.usecases.GetMoviesFromServerUseCase
import com.css101.starwarsuniverse.domain.usecases.GetMoviesFromStorageUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val getMoviesFromServerUseCase: GetMoviesFromServerUseCase,
    private val getMoviesFromStorageUseCase: GetMoviesFromStorageUseCase,
) : ViewModel() {

    private val _movies = MutableLiveData<List<Film>>()
    val movies: LiveData<List<Film>> = _movies

    fun getMovies() {
        _movies.value?.let { return }
        viewModelScope.launch(Dispatchers.IO) {
            val localMovies = getMoviesFromStorageUseCase.execute()
            val data = localMovies ?: getMoviesFromServerUseCase.execute() ?: emptyList()
            _movies.postValue(data.sortedBy { it.episodeId })
        }
    }
}