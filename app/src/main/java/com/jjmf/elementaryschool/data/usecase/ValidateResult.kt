package com.jjmf.elementaryschool.data.usecase

data class ValidateResult(
    val isSuccessfull:Boolean,
    val errorMessage:String? = null
)
