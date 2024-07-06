package com.css101.starwarsuniverse.domain.usecases

import com.css101.starwarsuniverse.domain.models.Character
import com.css101.starwarsuniverse.domain.repository.StorageRepo

class GetCharacterFromStorageUseCase(private val storageRepo: StorageRepo) {

    suspend fun execute(character: String): Character? {
        return storageRepo.getCharacterFromStorage(character)
    }
}