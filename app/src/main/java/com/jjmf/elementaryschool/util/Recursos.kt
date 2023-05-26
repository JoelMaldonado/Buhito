package com.jjmf.elementaryschool.util

import com.jjmf.elementaryschool.R

object Recursos {

    private val listAlumnos = listOf(
        R.drawable.alumno_1,
        R.drawable.alumno_2,
        R.drawable.alumno_3,
        R.drawable.alumno_4
    )

    fun getImgAlumno() = listAlumnos.random()

    private val listAlumnas = listOf(
        R.drawable.alumna_1,
        R.drawable.alumna_2,
        R.drawable.alumna_3,
        R.drawable.alumna_4,
        R.drawable.alumna_5,
    )
    fun getImgAlumna() = listAlumnas.random()

    private val listMaestros = listOf(
        R.drawable.maestro_1,
        R.drawable.maestro_2,
        R.drawable.maestro_3,
        R.drawable.maestro_4,
        R.drawable.maestro_5
    )
    fun getImgMaestro() = listMaestros.random()

    private val listMaestras = listOf(
        R.drawable.maestra_1,
        R.drawable.maestra_2,
        R.drawable.maestra_3,
        R.drawable.maestra_4
    )
    fun getImgMaestra() = listMaestras.random()

}