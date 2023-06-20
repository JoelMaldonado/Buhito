package com.jjmf.elementaryschool.ui.features.Profesor.VerCursosSalon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.CursoRepository
import com.jjmf.elementaryschool.model.Curso
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerCursosSalonViewModel @Inject constructor(
    private val repository: CursoRepository
) : ViewModel() {

    private val _listMaterias = MutableStateFlow<List<Curso>>(emptyList())
    val listMaterias: StateFlow<List<Curso>> = _listMaterias

    init {
        getMaterias()
    }

    private fun getMaterias() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.getListFlow().collect(){
                    _listMaterias.value = it
                }
            }catch (e:Exception){
                e.message
            }
        }
    }
}