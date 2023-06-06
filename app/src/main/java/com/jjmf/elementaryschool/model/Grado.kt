package com.jjmf.elementaryschool.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_grado")
data class Grado(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "idProfesor") val idProfesor: Int,
    @ColumnInfo(name = "profesor") val profesor: String
    // @ColumnInfo(name = "icono") @DrawableRes val icono: Int,
)