package com.laioffer.spotify

import android.app.Application
import com.laioffer.spotify.di.Engine
import com.laioffer.spotify.di.Gas
import com.laioffer.spotify.di.GasEngine
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application() {

    @Inject
    @Gas
    lateinit var engine: Engine

    @Inject
    lateinit var engine1: GasEngine


    override fun onCreate() {
        super.onCreate()
        val temp = engine
    }
}