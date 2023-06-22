package com.jjmf.elementaryschool.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_calificacion")
data class Calificacion(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "idAlumno") val idAlumno:Int,
    @ColumnInfo(name = "idProfesor") val idProfesor:Int,
    @ColumnInfo(name = "idCurso") val idCurso:Int,
    @ColumnInfo(name = "nota") val nota:Int,
    @ColumnInfo(name = "lapso") val lapso:Int
)
