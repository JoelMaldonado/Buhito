package com.jjmf.elementaryschool.ui.features.Director

import androidx.lifecycle.ViewModel
import com.jjmf.elementaryschool.util.Recursos
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MenuDirectorViewModel @Inject constructor(

) :ViewModel(){

    val icProfesor = Recursos.getMaestro()
    val icCurso = Recursos.getCurso()
    val icGrado = Recursos.getBuhito()

}