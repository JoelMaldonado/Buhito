package com.jjmf.elementaryschool.model

import com.google.gson.annotations.SerializedName

data class Curso(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("detalle") val detalle: String,
    @SerializedName("img") val img: String
)