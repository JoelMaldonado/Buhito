package com.jjmf.elementaryschool.ui.features.Director.VerProfesores.AsignarCurso

import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.CursoRepository
import com.jjmf.elementaryschool.model.Curso
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AsignarCursosViewModel @Inject constructor(
    private val repository: CursoRepository
) : ViewModel() {


    private val _listCursos = MutableStateFlow<List<Curso>>(emptyList())
    val listCursos: StateFlow<List<Curso>> = _listCursos

    init {
        getCursos()
    }

    private fun getCursos() {
        viewModelScope.launch(Dispatchers.IO){
            repository.getListFlow().collect(){
                _listCursos.value = it
            }
        }
    }

}