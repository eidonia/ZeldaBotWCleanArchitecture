package com.example.zeldabotwcleanarchitecture.data.dto

import retrofit2.http.GET
import retrofit2.http.Path

interface ZeldaApi {

    @GET("api/v2/category/monsters")
    suspend fun getMonsters(): List<MonsterDetailDto>

    @GET("api/v2/entry/{monsterId}")
    suspend fun getMonsterDetail(@Path("monsterId") monsterID: Int): MonsterDetailDto
}