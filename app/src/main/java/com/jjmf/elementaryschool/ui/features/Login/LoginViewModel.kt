package com.jjmf.elementaryschool.ui.features.Login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
                    tipoUsuario = "P",
                    genero = "H",
                    icono = Recursos.getMaestro()
                )
            )
        }
    }

}


fun main(){
    val listNotas = listOf("CLT","CNL","CNL","CLT")
    println("Tu nota es: ${getPromedio(listNotas)}")
}


fun getPromedio(list:List<String>) : String{
    var cont = 0.0
    list.forEach {
        println(getNota(it))
        cont += getNota(it)
    }

    val div = (cont / list.size)
    return toNota(div)
}








private fun getNota(nota:String): Double{

    return when(nota){
        "CLT"-> 17.5
        "CLP"-> 12.0
        "CEP"-> 7.0
        "CNL"-> 2.0
        else -> 0.0
    }
}

private fun toNota(nota:Double): String{
    return when(nota){
        in 15.0..20.0 -> "CLT"
        in 10.0..14.9 -> "CLP"
        in 5.0..9.9 -> "CEP"
        in 0.0..4.9 -> "CNL"
        else -> ""
    }
}











