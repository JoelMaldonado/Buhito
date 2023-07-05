package com.jjmf.elementaryschool.model

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("id") val id:Int,
    @SerializedName("documento") val documento:String,
    @SerializedName("nombre") val nombre:String,
    @SerializedName("apellidos") val apellidos:String,
    @SerializedName("celular") val celular:String,
    @SerializedName("tipoUsuario") val tipoUsuario:Int,
    @SerializedName("genero") val genero:String,
    @SerializedName("correo") val correo:String,
    @SerializedName("clave") val clave:String,
    @SerializedName("foto") val foto:String
)
