package com.css101.starwarsuniverse.di

import com.css101.starwarsuniverse.data.repository.StorageRepoImpl
import com.css101.starwarsuniverse.data.repository.SwapiRepoImpl
import com.css101.starwarsuniverse.data.storage.ExternalStorage
import com.css101.starwarsuniverse.data.storage.InternalStorage
import com.css101.starwarsuniverse.data.storage.retrofit.RetrofitStorage
import com.css101.starwarsuniverse.data.storage.room.RoomStorage
import com.css101.starwarsuniverse.domain.repository.StorageRepo
import com.css101.starwarsuniverse.domain.repository.SwapiRepo
import org.koin.dsl.module

val dataModule = module {
    single<StorageRepo> { StorageRepoImpl(get()) }
    single<SwapiRepo> { SwapiRepoImpl(externalStorage = get(), internalStorage = get()) }
    single<ExternalStorage> { RetrofitStorage() }
    single<InternalStorage> { RoomStorage(get()) }
}
