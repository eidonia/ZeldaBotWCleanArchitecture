package com.example.zeldabotwcleanarchitecture.data.remote.dto.detail_monster

import com.example.zeldabotwcleanarchitecture.domain.model.MonsterDetail

data class Data(
    val category: String,
    val common_locations: List<String>,
    val description: String,
    val drops: List<String>,
    val id: Int,
    val image: String,
    val name: String
)

fun Data.toMonsterDetail(): MonsterDetail =
    MonsterDetail(
        category = category,
        description = description,
        id = id,
        image = image,
        name = name
    )