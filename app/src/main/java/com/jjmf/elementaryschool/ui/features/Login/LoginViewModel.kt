package com.jjmf.elementaryschool.ui.features.Login

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.jjmf.elementaryschool.app.BaseApp.Companion.prefs
import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import com.jjmf.elementaryschool.model.Usuario
import com.jjmf.elementaryschool.util.Recursos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UsuarioRepository,
) : ViewModel() {

    var correo by mutableStateOf("joeljoas@gmail.com")
    var error by mutableStateOf<String?>(null)

    var toMenu by mutableStateOf<Int?>(null)
    var loader by mutableStateOf(false)

    var clave by mutableStateOf("12345678")

    fun signIn() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                loader = true
                Recursos.getImagenes()
                toMenu = 3
            } catch (e: Exception) {
                error = e.message
            }finally {
                loader = false
            }
        }
    }
}











