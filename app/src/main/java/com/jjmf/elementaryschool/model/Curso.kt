package com.jjmf.elementaryschool.model

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_curso")
data class Curso(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "detalle") val detalle: String,
    @ColumnInfo(name = "icono") @DrawableRes val icono: Int
)