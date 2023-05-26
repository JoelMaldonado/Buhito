package com.jjmf.elementaryschool.ui.features.Director.AgregarUsuario

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import com.jjmf.elementaryschool.model.Usuario
import com.jjmf.elementaryschool.util.Recursos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgregarUsuarioViewModel @Inject constructor(
    private val repository: UsuarioRepository,
) : ViewModel() {

    var back by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)

    var nombre by mutableStateOf("")
    var apellido by mutableStateOf("")
    var celular by mutableStateOf("")
    var correo by mutableStateOf("")
    var tipo by mutableStateOf(false)
    var genero by mutableStateOf(false)

    var iconoUsuarioMain by mutableStateOf(0)

    fun insertarUsuario(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val usuario = Usuario(
                    correo = correo,
                    clave = correo.substring(0,4) + "1234",
                    nombre = nombre,
                    apellido = apellido,
                    celular = celular,
                    tipoUsuario = if (tipo) "A" else "P",
                    genero = if (genero) "M" else "H",
                    icono = iconoUsuarioMain
                )
                repository.insert(usuario)
                back = true
            }catch (e:Exception){
                error = e.message
            }
        }
    }

    fun validarIcono() {
        iconoUsuarioMain = if (tipo){
            if (genero){
                Recursos.getAlumna()
            }else{
                Recursos.getAlumno()
            }
        }else{
            if (genero){
                Recursos.getMaestra()
            }else{
                Recursos.getMaestro()
            }
        }
    }

}