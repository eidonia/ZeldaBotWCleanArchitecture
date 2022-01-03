package com.example.zeldabotwcleanarchitecture.ui.monster_detail

import com.example.zeldabotwcleanarchitecture.domain.model.MonsterDetail

data class MonsterDetailState(
    val isLoading: Boolean = false,
    val monster: MonsterDetail? = null,
    val error: String = ""
)
