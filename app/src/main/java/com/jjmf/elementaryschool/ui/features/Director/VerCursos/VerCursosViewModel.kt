package com.jjmf.elementaryschool.ui.features.Director.VerCursos

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.CursoRepository
import com.jjmf.elementaryschool.model.Curso
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerCursosViewModel @Inject constructor(
    private val repository: CursoRepository,
) : ViewModel() {

    var error by mutableStateOf<String?>(null)
    var listCursos by mutableStateOf<List<Curso>>(emptyList())

    fun getCursos() {
        viewModelScope.launch(Dispatchers.IO){
            try {
                repository.getListFlow().collect(){
                    listCursos = it
                }
            }catch (e:Exception){
                error = e.message
            }
        }
    }

    fun deleteCurso(curso: Curso) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                repository.delete(curso)
            }catch (e:Exception){
                error = e.message
            }
        }
    }
}