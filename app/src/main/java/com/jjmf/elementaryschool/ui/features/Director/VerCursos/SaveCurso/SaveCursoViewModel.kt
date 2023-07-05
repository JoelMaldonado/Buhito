package com.jjmf.elementaryschool.ui.features.Director.VerCursos.SaveCurso

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.core.EstadosResult
import com.jjmf.elementaryschool.data.repository.CursoRepository
import com.jjmf.elementaryschool.data.usecase.Imagenes
import com.jjmf.elementaryschool.model.Curso
import com.jjmf.elementaryschool.util.Recursos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveCursoViewModel @Inject constructor(
    private val repository: CursoRepository,
    private val imagenes: Imagenes
) : ViewModel() {

    var listCursos by mutableStateOf<List<String>>(emptyList())

    var nombreCurso by mutableStateOf("")
    var alertSeleccionarIcono by mutableStateOf(false)
    var iconoCursoMain by mutableStateOf("")

    var error by mutableStateOf<String?>(null)
    var back by mutableStateOf(false)

    fun insertarCurso() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val curso = Curso(
                    detalle = nombreCurso,
                    img = iconoCursoMain.toString()
                )
                when (val res = repository.insert(curso)) {
                    is EstadosResult.Correcto -> back = true
                    is EstadosResult.Error -> error = res.mensajeError
                }
            } catch (e: Exception) {
                error = e.message
            }
        }
    }

    fun getImagenesCursos() {
        viewModelScope.launch(Dispatchers.IO){
            listCursos = imagenes.cursos()
            if (listCursos.isNotEmpty()){
                iconoCursoMain = listCursos.first()
            }
        }
    }
}