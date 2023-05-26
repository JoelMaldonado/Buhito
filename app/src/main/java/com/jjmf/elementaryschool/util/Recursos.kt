package com.jjmf.elementaryschool.util

import com.jjmf.elementaryschool.R

object Recursos {


    val listCursos = listOf(
        R.drawable.curso_1,
        R.drawable.curso_2,
        R.drawable.curso_3,
        R.drawable.curso_4,
        R.drawable.curso_5,
        R.drawable.curso_6,
        R.drawable.curso_7,
        R.drawable.curso_8,
        R.drawable.curso_9,
        R.drawable.curso_10,
        R.drawable.curso_11,
        R.drawable.curso_12,
        R.drawable.curso_13,
        R.drawable.curso_14,
        R.drawable.curso_15,
        R.drawable.curso_16
    )

    fun getCurso() = listCursos.random()

    private val listBuhitos = listOf(
        R.drawable.buho_1,
        R.drawable.buho_2,
        R.drawable.buho_3,
        R.drawable.buho_4,
        R.drawable.buho_5,
        R.drawable.buho_6,
        R.drawable.buho_7,
        R.drawable.buho_8,
        R.drawable.buho_9,
    )

    fun getBuhito() = listBuhitos.random()

    private val listAlumnos = listOf(
        R.drawable.alumno_1,
        R.drawable.alumno_2,
        R.drawable.alumno_3,
        R.drawable.alumno_4
    )

    fun getAlumno() = listAlumnos.random()

    val listAlumnas = listOf(
        R.drawable.alumna_1,
        R.drawable.alumna_2,
        R.drawable.alumna_3,
        R.drawable.alumna_4,
        R.drawable.alumna_5,
    )
    fun getAlumna() = listAlumnas.random()

    val listMaestros = listOf(
        R.drawable.maestro_1,
        R.drawable.maestro_2,
        R.drawable.maestro_3,
        R.drawable.maestro_4,
        R.drawable.maestro_5
    )

    fun getMaestro() = listMaestros.random()

    val listMaestras = listOf(
        R.drawable.maestra_1,
        R.drawable.maestra_2,
        R.drawable.maestra_3,
        R.drawable.maestra_4
    )
    fun getMaestra() = listMaestras.random()

}