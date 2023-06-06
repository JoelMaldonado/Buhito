package com.jjmf.elementaryschool.ui.features.Login

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.usecase.LoginUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val usecase: LoginUsecase
) : ViewModel() {

    var correo by mutableStateOf("")
    var error by mutableStateOf<String?>(null)

    var toMenu by mutableStateOf(false)

    var clave by mutableStateOf("12345678")

    fun signIn(){
        viewModelScope.launch(Dispatchers.IO){
            val correoValidado = usecase.validateCorreoUseCase(correo)
            val claveValidada = usecase.validateClaveUseCase(clave)

            when(true){
                !correoValidado.isSuccessfull -> error = correoValidado.errorMessage
                !claveValidada.isSuccessfull -> error = claveValidada.errorMessage
                else -> {
                    val signIn = usecase.signIn(correo, clave)
                    if (signIn.isSuccessfull){
                        toMenu = true
                    }else{
                        error = signIn.errorMessage
                    }
                }
            }
        }
    }
}