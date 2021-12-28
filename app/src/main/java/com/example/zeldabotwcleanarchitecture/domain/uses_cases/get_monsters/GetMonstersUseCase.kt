package com.example.zeldabotwcleanarchitecture.domain.uses_cases.get_monsters

import com.example.zeldabotwcleanarchitecture.common.Resource
import com.example.zeldabotwcleanarchitecture.data.dto.toMonsterDetail
import com.example.zeldabotwcleanarchitecture.domain.model.MonsterDetail
import com.example.zeldabotwcleanarchitecture.domain.repository.MonsterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMonstersUseCase @Inject constructor(private val repo: MonsterRepository){

    operator fun invoke(): Flow<Resource<List<MonsterDetail>>> = flow {
        try {
            emit(Resource.Loading())
            val monsters = repo.getMonsters().map {
                it.toMonsterDetail()
            }
            emit(Resource.Success(monsters))

        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
    }
}