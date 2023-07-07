package com.jjmf.elementaryschool.ui.features.Login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UsuarioRepository,
) : ViewModel() {

    var correo by mutableStateOf("joelmaldonado@hotmail.com")
    var clave by mutableStateOf("123456")
    var error by mutableStateOf<String?>(null)

    var toMenu by mutableStateOf<Int?>(null)
    var loader by mutableStateOf(false)


    fun signIn() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                loader = true
                toMenu = 3
            } catch (e: Exception) { error = e.message }
            finally { loader = false }
        }
    }
}











