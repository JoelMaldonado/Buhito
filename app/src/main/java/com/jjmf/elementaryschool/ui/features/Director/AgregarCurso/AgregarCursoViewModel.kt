package com.jjmf.elementaryschool.ui.features.Director.AgregarCurso

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.GradoRepository
import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import com.jjmf.elementaryschool.model.Grado
import com.jjmf.elementaryschool.model.Usuario
import com.jjmf.elementaryschool.util.Recursos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgregarCursoViewModel @Inject constructor(
    private val repository: GradoRepository,
    private val repoUsuario: UsuarioRepository
) : ViewModel() {
    var nombreCurso by mutableStateOf("")
    var alertSeleccionarIcono by mutableStateOf(false)
    var iconoCursoMain by mutableStateOf(0)

    init {
        iconoCursoMain = Recursos.getCurso()
    }

    var grado by mutableStateOf("")

    var profesor by mutableStateOf("")

    var error by mutableStateOf<String?>(null)
    var back by mutableStateOf(false)

    var listProfesores by mutableStateOf<List<Usuario>>(emptyList())

    var selectedItem by mutableStateOf<Usuario?>(null)

    fun insertarCurso() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                selectedItem?.let { profe->
                    val curso = Grado(
                        nombre = grado,
                        idProfesor = profe.id,
                        profesor = profe.nombre
                    )
                    repository.insert(curso)
                    back = true
                }
            } catch (e: Exception) {
                error = e.message
            }
        }
    }

    fun getProfesores() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repoUsuario.getListFlow().collect() {
                    listProfesores = it.filter { it.tipoUsuario == "P" }
                }
            } catch (e: Exception) {
                error = e.message
            }
        }
    }

    fun selectUsuario(usuario: Usuario) {
        selectedItem = usuario
    }

}