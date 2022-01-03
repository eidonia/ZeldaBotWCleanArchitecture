package com.example.zeldabotwcleanarchitecture.data.repository

import com.example.zeldabotwcleanarchitecture.data.remote.ZeldaApi
import com.example.zeldabotwcleanarchitecture.data.remote.dto.detail_monster.MonsterDetailDto
import com.example.zeldabotwcleanarchitecture.data.remote.dto.list_monsters.DataMonsterDto
import com.example.zeldabotwcleanarchitecture.domain.repository.MonsterRepository
import javax.inject.Inject

class MonsterRepositoryImpl @Inject constructor(private val api: ZeldaApi): MonsterRepository {
    override suspend fun getMonsters(): DataMonsterDto = api.getMonsters()

    override suspend fun getMonsterDetail(id: Int): MonsterDetailDto = api.getMonsterDetail(id)
}