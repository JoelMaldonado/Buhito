package com.jjmf.elementaryschool.ui.features.Login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.app.BaseApp.Companion.prefs
import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import com.jjmf.elementaryschool.model.Usuario
import com.jjmf.elementaryschool.util.Recursos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.jar.Manifest
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UsuarioRepository,
) : ViewModel() {

    var correo by mutableStateOf("joeljoas@gmail.com")
    var error by mutableStateOf<String?>(null)

    var toMenu by mutableStateOf<String?>(null)

    var clave by mutableStateOf("12345678")

    fun signIn() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val usuario = repository.getList()
                    .find { it.correo.trim() == correo && it.clave.trim() == clave }
                if (usuario != null) {
                    prefs.saveId(usuario.id)
                    toMenu = usuario.tipoUsuario
                } else {
                    error = "Usuario y/o contraseña son incorrectas"
                }
            } catch (e: Exception) {
                error = e.message
            }
        }
    }

    fun insertarUsuarioTest() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(
                Usuario(
                    correo = "joeljoas@gmail.com",
                    clave = "12345678",
                    nombre = "Joel",
                    apellido = "Maldonado",
                    celular = "936416623",
                    tipoUsuario = "D",
                    genero = "H",
                    icono = Recursos.getMaestro()
                )
            )
        }
    }
}











