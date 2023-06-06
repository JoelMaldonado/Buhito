package com.jjmf.elementaryschool.data.usecase.Login

import android.util.Patterns
import com.jjmf.elementaryschool.data.usecase.ValidateResult

class ValidateCorreoUseCase {

    operator fun invoke(correo:String) : ValidateResult {

        if(correo.isBlank()){
            return ValidateResult(
                isSuccessfull = false,
                errorMessage = "El correo no puede estar en blanco"
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            return ValidateResult(
                isSuccessfull = false,
                errorMessage = "El correo no es valido"
            )
        }

        //conexion a un backend para verificar si existe ese correo o no

        return ValidateResult(
            isSuccessfull = true
        )
    }

}