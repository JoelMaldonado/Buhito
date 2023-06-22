package com.jjmf.elementaryschool.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_seccionusuario")
data class SeccionUsuario(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "idProfesor") val idProfesor:Int,
    @ColumnInfo(name = "idAlumno") val idAlumno:Int,
    @ColumnInfo(name = "idSeccion") val idSeccion:Int
)