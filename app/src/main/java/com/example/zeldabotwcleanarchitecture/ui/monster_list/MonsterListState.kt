package com.example.zeldabotwcleanarchitecture.ui.monster_list

import com.example.zeldabotwcleanarchitecture.domain.model.MonsterDetail

data class MonsterListState(
    val isLoading: Boolean = false,
    val monsters: List<MonsterDetail> = emptyList(),
    val error: String = ""
) {

}
