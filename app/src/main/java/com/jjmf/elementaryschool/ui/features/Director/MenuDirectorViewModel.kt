package com.jjmf.elementaryschool.ui.features.Director

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.ImagenesRepository
import com.jjmf.elementaryschool.data.usecase.Imagenes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MenuDirectorViewModel @Inject constructor(
    private val imagenes: Imagenes
) :ViewModel(){

    var icProfesor by mutableStateOf("")
    var icGrado by mutableStateOf("")

    init {
        viewModelScope.launch(Dispatchers.IO){
            imagenes.cursos().firstOrNull()?.let {
                icProfesor = it
            }
            imagenes.buhitos().firstOrNull()?.let {
                icGrado = it
            }
        }
    }

}