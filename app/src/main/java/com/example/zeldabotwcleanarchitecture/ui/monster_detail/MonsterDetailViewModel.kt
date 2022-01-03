package com.example.zeldabotwcleanarchitecture.ui.monster_detail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeldabotwcleanarchitecture.common.Resource
import com.example.zeldabotwcleanarchitecture.domain.uses_cases.get_monster_detail.GetMonsterDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MonsterDetailViewModel @Inject constructor(private val useCase: GetMonsterDetailUseCase, id: Int): ViewModel() {

    private val _state = MutableLiveData<MonsterDetailState>()
    val state: LiveData<MonsterDetailState> get() = _state

    init {
        getMonsterDetail(id)
    }

    private fun getMonsterDetail(monsterId: Int) {
        useCase(monsterId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = MonsterDetailState(monster = result.data)
                }
                is Resource.Error -> {
                    _state.value = MonsterDetailState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = MonsterDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}