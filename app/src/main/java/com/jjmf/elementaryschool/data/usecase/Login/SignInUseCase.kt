package com.jjmf.elementaryschool.data.usecase.Login

import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import com.jjmf.elementaryschool.data.usecase.ValidateResult
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: UsuarioRepository
) {
    suspend operator fun invoke(correo: String, clave: String) : ValidateResult {
        val listado = repository.getList()

        val usuario = listado.find { it.correo.trim() == correo && it.clave == clave }

        return if (usuario!=null){
            ValidateResult(
                isSuccessfull = true
            )
        } else {
            ValidateResult(
                isSuccessfull = false,
                errorMessage = "Usuario y/o clave son incorrectas"
            )
        }

    }
}