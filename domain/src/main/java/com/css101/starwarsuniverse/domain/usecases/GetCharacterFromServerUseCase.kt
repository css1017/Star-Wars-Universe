package com.css101.starwarsuniverse.domain.usecases

import com.css101.starwarsuniverse.domain.models.Character
import com.css101.starwarsuniverse.domain.repository.SwapiRepo

class GetCharacterFromServerUseCase(private val swapiRepo: SwapiRepo) {

    suspend fun execute(character: String): Character? {
        return swapiRepo.getAndSaveCharacter(character)
    }
}