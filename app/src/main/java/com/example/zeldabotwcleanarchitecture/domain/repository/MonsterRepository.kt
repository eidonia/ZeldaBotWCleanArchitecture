package com.example.zeldabotwcleanarchitecture.domain.repository

import com.example.zeldabotwcleanarchitecture.data.remote.dto.detail_monster.MonsterDetailDto
import com.example.zeldabotwcleanarchitecture.data.remote.dto.list_monsters.DataMonsterDto

interface MonsterRepository {
    suspend fun getMonsters(): DataMonsterDto
    suspend fun getMonsterDetail(id: Int): MonsterDetailDto
}