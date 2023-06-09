package com.jjmf.elementaryschool.ui.features.Director.VerProfesores.AddEditProfesor

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.SeccionRepository
import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import com.jjmf.elementaryschool.model.Seccion
import com.jjmf.elementaryschool.model.Usuario
import com.jjmf.elementaryschool.util.Recursos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditProfesorViewModel @Inject constructor(
    private val repository: UsuarioRepository,
    private val repoGrado: SeccionRepository,
) : ViewModel() {

    var listGrados by mutableStateOf<List<Seccion>>(emptyList())

    var alertAsignarGrado by mutableStateOf(false)
    var back by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)

    var nombre by mutableStateOf("")
    var apellido by mutableStateOf("")
    var celular by mutableStateOf("")
    var correo by mutableStateOf("")
    var seccion by mutableStateOf<Seccion?>(null)
    var genero by mutableStateOf(false)

    var iconoUsuarioMain by mutableStateOf(0)

    fun getListGrados() {
        viewModelScope.launch(Dispatchers.IO) {
            listGrados = repoGrado.getList(0)
        }
    }

    fun insertarUsuario() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val usuario = Usuario(
                    correo = correo,
                    clave = "12345678",
                    nombre = nombre,
                    apellido = apellido,
                    celular = celular,
                    tipoUsuario = "P",
                    genero = if (genero) "M" else "H",
                    icono = iconoUsuarioMain
                )
                repository.insert(usuario)
                back = true
            } catch (e: Exception) {
                error = e.message
            }
        }
    }

    fun validarIcono() {
        iconoUsuarioMain = if (genero) {
            Recursos.getMaestra()
        } else {
            Recursos.getMaestro()
        }
    }

    fun getUser(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = repository.getList().find { it.id == id }
            user?.let {
                nombre = it.nombre
                apellido = it.apellido
                celular = it.celular
                correo = it.correo
                //seccion = ""
                genero = it.genero == "M"
                iconoUsuarioMain = it.icono
            }
        }
    }

}