package com.jjmf.elementaryschool.ui.features.Director.VerCursos.AddEditCurso

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.CursoRepository
import com.jjmf.elementaryschool.model.Curso
import com.jjmf.elementaryschool.util.Recursos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditCursoViewModel @Inject constructor(
    private val repository: CursoRepository,
) : ViewModel() {
    var nombreCurso by mutableStateOf("")
    var alertSeleccionarIcono by mutableStateOf(false)
    var iconoCursoMain by mutableStateOf(Recursos.getCurso())

    var error by mutableStateOf<String?>(null)
    var back by mutableStateOf(false)

    fun insertarCurso() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val curso = Curso(
                    detalle = nombreCurso,
                    icono = iconoCursoMain
                )
                repository.insert(curso)
                back = true

            } catch (e: Exception) {
                error = e.message
            }
        }
    }
}