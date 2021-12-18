package com.example.zeldabotwcleanarchitecture.data.dto

data class MonstersDto(
    val category: String,
    val common_locations: Any,
    val description: String,
    val drops: List<String>,
    val id: Int,
    val image: String,
    val name: String
)