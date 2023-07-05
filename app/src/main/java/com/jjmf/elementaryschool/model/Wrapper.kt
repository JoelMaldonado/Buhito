package com.jjmf.elementaryschool.model

data class Wrapper<T>(
    val isSuccess: Boolean,
    val message: String,
    val code: Int,
    val data: T
)
