package com.jjmf.elementaryschool.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_seccion")
data class Seccion(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "detalle") val detalle:Char,
    @ColumnInfo(name = "grado") val grado:Int,
    @ColumnInfo(name = "idUsuario") val idUsuario:Int = 0
)


