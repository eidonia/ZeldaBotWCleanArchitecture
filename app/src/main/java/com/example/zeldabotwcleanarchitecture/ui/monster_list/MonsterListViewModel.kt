package com.example.zeldabotwcleanarchitecture.ui.monster_list

import android.util.Log
import androidx.lifecycle.*
import com.example.zeldabotwcleanarchitecture.common.Resource
import com.example.zeldabotwcleanarchitecture.domain.uses_cases.get_monsters.GetMonstersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MonsterListViewModel @Inject constructor(private val useCase: GetMonstersUseCase): ViewModel() {

    private val _state = MutableLiveData<MonsterListState>()
    val state: LiveData<MonsterListState> get() = _state

    init {
        getMonsters()
    }

    private fun getMonsters() {
        useCase().onEach { result ->
            when(result) {
                is Resource.Success -> {

                    _state.value = MonsterListState(monsters = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MonsterListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = MonsterListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}