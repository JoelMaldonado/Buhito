package com.jjmf.elementaryschool.model

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "correo") val correo:String,
    @ColumnInfo(name = "clave") val clave:String,
    @ColumnInfo(name = "nombre") val nombre:String,
    @ColumnInfo(name = "apellido") val apellido:String,
    @ColumnInfo(name = "celular") val celular:String,
    @ColumnInfo(name = "tipoUsuario") val tipoUsuario:String,
    @ColumnInfo(name = "genero") val genero:String,
    @ColumnInfo(name = "icono") @DrawableRes val icono:Int
)
