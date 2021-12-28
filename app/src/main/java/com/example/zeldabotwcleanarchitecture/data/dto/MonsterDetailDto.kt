package com.example.zeldabotwcleanarchitecture.data.dto

import com.example.zeldabotwcleanarchitecture.domain.model.MonsterDetail

data class MonsterDetailDto(
    val category: String,
    val common_locations: Any,
    val description: String,
    val drops: List<String>,
    val id: Int,
    val image: String,
    val name: String
)

fun MonsterDetailDto.toMonsterDetail(): MonsterDetail =
    MonsterDetail(
        category = category,
        description = description,
        id = id,
        image = image,
        name = name
    )

