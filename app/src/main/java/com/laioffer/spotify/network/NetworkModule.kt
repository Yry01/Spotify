package com.laioffer.spotify.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//
@Module
@InstallIn(
    SingletonComponent::class)
object NetworkModule {

    // 10.0.2.2 is the localhost of the host machine
    private const val BASE_URL = "http://10.0.2.2:8080/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): NetworkApi {
        return retrofit.create(NetworkApi::class.java)
    }
}
//
//fun main() {
//    val networkModule = NetworkModule
//    val networkModule1 = NetworkModule
//    networkModule == networkModule1
//
//    val networkModule2 = NetworkModule1()
//    val networkModule3 = NetworkModule1()
//    networkModule2 != networkModule3
//
//    val retrofit = networkModule.provideRetrofit()
//    val retrofit1 = networkModule1.provideRetrofit()
//    retrofit != retrofit1
//
//
//    val retrofit2 = networkModule2.provideRetrofit()
//    val retrofit3 = networkModule3.provideRetrofit()
//
//    retrofit != retrofit1
//
//}
//
//class NetworkModule1 {
//    companion object {
//        private const val BASE_URL = "http://10.0.2.2:8080/"
//    }
//
//    fun provideRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(OkHttpClient())
//            .build()
//    }
//}