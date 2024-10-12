package com.laioffer.spotify.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

class Car @Inject constructor(
    @Gas private val engine: Engine,
    private val gasEngine: GasEngine) {

}

open class Engine constructor() {

}

@Singleton
class GasEngine @Inject constructor(): Engine() {

}

class Cylinder @Inject constructor() {

}

class ElectricalEngine @Inject constructor(): Engine() {

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Gas

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Electric

@Module
@InstallIn(SingletonComponent::class)
object CarModule {
//    @Provides
//    fun provideGasEngine2(): GasEngine {
//        return GasEngine()
//    }


//    @Provides
//    @Gas
//    @Singleton
//    fun provideGasEngine1(): Engine {
//        return GasEngine()
//    }

    @Provides
    @Singleton
    @Gas
    fun provideGasEngine(gasEngine: GasEngine): Engine {
        return gasEngine
    }

    @Provides
    @Electric
    @Singleton
    fun provideElectricalEngine(electricalEngine: ElectricalEngine): Engine {
        return electricalEngine
    }

//    @Binds
//    abstract fun provideEngine(gasEngine: GasEngine): Engine

}
