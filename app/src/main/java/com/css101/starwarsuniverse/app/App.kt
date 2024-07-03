package com.css101.starwarsuniverse.app

import android.app.Application
import com.css101.starwarsuniverse.di.dataModule
import com.css101.starwarsuniverse.di.domainModule
import com.css101.starwarsuniverse.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}