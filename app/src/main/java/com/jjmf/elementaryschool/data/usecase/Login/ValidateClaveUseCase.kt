package com.jjmf.elementaryschool.data.usecase.Login

import android.util.Patterns
import com.jjmf.elementaryschool.data.usecase.ValidateResult

class ValidateClaveUseCase {

    operator fun invoke(clave:String) : ValidateResult {
        if(clave.isBlank()){
            return ValidateResult(
                isSuccessfull = false,
                errorMessage = "La clave no puede estar en blanco"
            )
        }

        return ValidateResult(
            isSuccessfull = true
        )
    }

}