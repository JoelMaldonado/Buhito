package com.jjmf.elementaryschool.data.usecase

import com.jjmf.elementaryschool.data.usecase.Login.SignInUseCase
import com.jjmf.elementaryschool.data.usecase.Login.ValidateClaveUseCase
import com.jjmf.elementaryschool.data.usecase.Login.ValidateCorreoUseCase

data class LoginUsecase(
    val validateCorreoUseCase: ValidateCorreoUseCase,
    val validateClaveUseCase: ValidateClaveUseCase,
    val signIn:SignInUseCase
)
