package com.jjmf.elementaryschool.ui.features.Director.AgregarUsuario

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgregarUsuarioViewModel @Inject constructor(
    private val repository: UsuarioRepository,
) : ViewModel() {

    var nombre by mutableStateOf("")
    var correo by mutableStateOf("")
    var tipo by mutableStateOf(false)
    var genero by mutableStateOf(false)

}