package com.css101.starwarsuniverse.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.css101.starwarsuniverse.domain.models.Film
import com.css101.starwarsuniverse.domain.usecases.GetMoviesFromServerUseCase
import com.css101.starwarsuniverse.domain.usecases.GetMoviesFromStorageUseCase
import com.css101.starwarsuniverse.domain.usecases.SaveMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val getMoviesFromServerUseCase: GetMoviesFromServerUseCase,
    private val getMoviesFromStorageUseCase: GetMoviesFromStorageUseCase,
    private val saveMoviesUseCase: SaveMoviesUseCase
) : ViewModel() {

    private val _movies = MutableLiveData<List<Film>>()
    val movies: LiveData<List<Film>> = _movies

    fun getMovies() {
        if (_movies.value != null) {
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            val localMovies = getMoviesFromStorageUseCase.execute()
            if (localMovies.isEmpty()) {
                val remoteMovies = getMoviesFromServerUseCase.execute()
                _movies.postValue(remoteMovies)
                saveMoviesUseCase.execute(remoteMovies)
            } else _movies.postValue(localMovies)
        }
    }
}