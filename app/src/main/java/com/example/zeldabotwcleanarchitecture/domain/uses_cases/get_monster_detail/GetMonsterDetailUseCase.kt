package com.example.zeldabotwcleanarchitecture.domain.uses_cases.get_monster_detail

import com.example.zeldabotwcleanarchitecture.common.Resource
import com.example.zeldabotwcleanarchitecture.data.remote.dto.detail_monster.toMonsterDetail
import com.example.zeldabotwcleanarchitecture.domain.model.MonsterDetail
import com.example.zeldabotwcleanarchitecture.domain.repository.MonsterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMonsterDetailUseCase @Inject constructor(private val repo: MonsterRepository) {

    operator fun invoke(monsterId: Int): Flow<Resource<MonsterDetail>> = flow {
        try {
            emit(Resource.Loading())
            val data = repo.getMonsterDetail(monsterId).data
            val monster = data.toMonsterDetail()
            emit(Resource.Success(monster))

        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }

}