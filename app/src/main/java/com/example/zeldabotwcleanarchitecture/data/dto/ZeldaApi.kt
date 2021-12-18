package com.example.zeldabotwcleanarchitecture.data.dto

import retrofit2.http.GET
import retrofit2.http.Path

interface ZeldaApi {

    @GET("api/v2/category/monsters")
    suspend fun getMonsters(): List<MonstersDto>

    @GET("api/v2/entry/{monsterId}")
    suspend fun getMonsters(@Path("monsterId") monsterID: Int): List<MonstersDto>
}