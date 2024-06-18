package com.leandro.image_search.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.dsl.koinApplication

internal interface ImageSearchKoinComponent : KoinComponent {
    override fun getKoin(): Koin = ImageSearchKoinApplication.koinApplication.koin
}

internal object ImageSearchKoinApplication {
    fun initialize(applicationContext: Context) {
        koinApplication = koinApplication {
            androidContext(applicationContext)
            modules(allModules)
        }
    }

    lateinit var koinApplication: KoinApplication
}
