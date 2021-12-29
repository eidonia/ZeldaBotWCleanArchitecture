package com.example.zeldabotwcleanarchitecture.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ZeldaApi {

    @GET("category/monsters")
    suspend fun getMonsters(): List<MonsterDetailDto>

    @GET("entry/{monsterId}")
    suspend fun getMonsterDetail(@Path("monsterId") monsterID: Int): MonsterDetailDto
}