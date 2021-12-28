package com.example.zeldabotwcleanarchitecture.domain.uses_cases.get_monster_detail

import com.example.zeldabotwcleanarchitecture.domain.repository.MonsterRepository
import javax.inject.Inject

class GetMonsterDetailUseCase @Inject constructor(private val repo: MonsterRepository) {
}