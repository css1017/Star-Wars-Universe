package com.css101.starwarsuniverse.presentation.planet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.css101.starwarsuniverse.domain.models.Planet
import com.css101.starwarsuniverse.domain.usecases.GetPlanetFromServerUseCase
import com.css101.starwarsuniverse.domain.usecases.GetPlanetFromStorageUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlanetViewModel(
    private val getPlanetFromServerUseCase: GetPlanetFromServerUseCase,
    private val getPlanetFromStorageUseCase: GetPlanetFromStorageUseCase
) : ViewModel() {
    private val _planet = MutableLiveData<Planet?>()
    val planet: LiveData<Planet?> = _planet

    fun getPlanet(homeWorld: String) {
        _planet.value?.let { return }

        viewModelScope.launch(Dispatchers.IO) {
            val localPlanet = getPlanetFromStorageUseCase.execute(homeWorld)
            val planet = localPlanet ?: getPlanetFromServerUseCase.execute(homeWorld)
            _planet.postValue(planet)
        }
    }

}