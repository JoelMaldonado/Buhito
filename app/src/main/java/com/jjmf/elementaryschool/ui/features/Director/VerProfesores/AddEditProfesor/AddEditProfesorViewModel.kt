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
    var toAsignar by mutableStateOf<Int?>(null)
    var error by mutableStateOf<String?>(null)

    var nombre by mutableStateOf("")
    var apellido by mutableStateOf("")
    var celular by mutableStateOf("")
    var correo by mutableStateOf("")
    var seccion by mutableStateOf<Seccion?>(null)
    var genero by mutableStateOf(false)

    var iconoUsuarioMain by mutableStateOf("")

    fun getListGrados() {
        viewModelScope.launch(Dispatchers.IO) {
            listGrados = repoGrado.getList(0)
        }
    }

    fun insertarUsuario() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
            } catch (e: Exception) {
                error = e.message
            }
        }
    }

    fun validarIcono() {
        iconoUsuarioMain = if (genero) ({
        //TODO buscar imagen maestra
            ""
        //Recursos.getMaestra()
        }).toString() else ({
            //TODO buscar imagen maestra
            //Recursos.getMaestro()
            ""
        }).toString()
    }

    fun getUser(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = repository.getList().find { it.id == id }
            user?.let {
                nombre = it.nombre
                apellido = it.apellidos
                celular = it.celular
                correo = it.correo
                //seccion = ""
            }
        }
    }

    fun insertupdateUsuario(id:Int?) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                if(id!=null){
                    //TODO Aqui se debe actualizar
                }else{
                    val usuario = Usuario(
                        correo = correo,
                        clave = "12345678",
                        nombre = nombre,
                        apellidos = apellido,
                        celular = celular,
                        tipoUsuario = 1,
                        genero = if (genero) "M" else "H",
                        foto = "",
                        documento = "",
                        id = 0
                    )
                    repository.insert(usuario)
                    val rpta = repository.getList().find { it.correo == correo }
                    toAsignar = rpta?.id
                }

            }catch (e:Exception){
                error = e.message
            }
        }
    }

}