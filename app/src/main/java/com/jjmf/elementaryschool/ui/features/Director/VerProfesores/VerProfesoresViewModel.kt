package com.jjmf.elementaryschool.ui.features.Director.VerProfesores

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import com.jjmf.elementaryschool.model.Usuario
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerProfesoresViewModel @Inject constructor(
    private val repository: UsuarioRepository,
) : ViewModel() {

    var filtro by mutableStateOf("")
    var listUsuarios by mutableStateOf<List<Usuario>>(emptyList())
    var listUsuariosMain by mutableStateOf<List<Usuario>>(emptyList())
    var error by mutableStateOf<String?>(null)

    fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.getListFlow().collect() { list ->
                    listUsuariosMain = list.filter { it.tipoUsuario == 2 }
                    listUsuarios = listUsuariosMain
                }
            } catch (e: Exception) {
                error = e.message
            }
        }
    }

    fun delete(user: Usuario) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.delete(user)
            } catch (e: Exception) {
                error = e.message
            }
        }
    }

}