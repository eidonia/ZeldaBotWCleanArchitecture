package com.example.zeldabotwcleanarchitecture.data.remote

import com.example.zeldabotwcleanarchitecture.data.remote.dto.detail_monster.MonsterDetailDto
import com.example.zeldabotwcleanarchitecture.data.remote.dto.list_monsters.DataMonsterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ZeldaApi {

    @GET("category/monsters")
    suspend fun getMonsters(): DataMonsterDto

    @GET("entry/{monsterId}")
    suspend fun getMonsterDetail(@Path("monsterId") monsterID: Int): MonsterDetailDto
}