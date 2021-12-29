package com.example.zeldabotwcleanarchitecture.domain.repository

import com.example.zeldabotwcleanarchitecture.data.remote.MonsterDetailDto

interface MonsterRepository {
    suspend fun getMonsters(): List<MonsterDetailDto>
    suspend fun getMonsterDetail(id: Int): MonsterDetailDto
}