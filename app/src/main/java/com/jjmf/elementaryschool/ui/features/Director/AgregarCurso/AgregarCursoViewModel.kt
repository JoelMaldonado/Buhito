package com.jjmf.elementaryschool.ui.features.Director.AgregarCurso

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jjmf.elementaryschool.util.Recursos
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgregarCursoViewModel @Inject constructor(

) : ViewModel() {
    var nombreCurso by mutableStateOf("")
    var alertSeleccionarIcono by mutableStateOf(false)
    var iconoCursoMain by mutableStateOf(0)

    init {
        iconoCursoMain = Recursos.getCurso()
    }

}