package com.jjmf.elementaryschool.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "nombre") val nombre:String,
    @ColumnInfo(name = "correo") val correo:String,
    @ColumnInfo(name = "clave") val clave:String,
    @ColumnInfo(name = "tipoUsuario") val tipoUsuario:String
)
