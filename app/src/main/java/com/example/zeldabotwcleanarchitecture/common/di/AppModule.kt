package com.example.zeldabotwcleanarchitecture.common.di

import com.example.zeldabotwcleanarchitecture.data.remote.ZeldaApi
import com.example.zeldabotwcleanarchitecture.data.repository.MonsterRepositoryImpl
import com.example.zeldabotwcleanarchitecture.domain.repository.MonsterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesMonstersApi(): ZeldaApi {
        return Retrofit.Builder()
            .baseUrl("https://botw-compendium.herokuapp.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ZeldaApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMonsterRepo(api: ZeldaApi): MonsterRepository {
        return MonsterRepositoryImpl(api)
    }

}