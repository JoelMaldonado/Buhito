package com.jjmf.elementaryschool.util

import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await

object Recursos {

    var listAlumnas = emptyList<String>()
    var listAlumnos = emptyList<String>()
    var listBuhitos = emptyList<String>()
    var listMaestros = emptyList<String>()
    var listMaestras = emptyList<String>()

    suspend fun getImagenes() {
        val storage = FirebaseStorage.getInstance().reference

        val imgAlumnos = storage.child("ic_alumnos").listAll().await()
        listAlumnos = imgAlumnos.items.map { it.downloadUrl.await().toString() }

        val imgBuhitos = storage.child("ic_buhito").listAll().await()
        listBuhitos = imgBuhitos.items.map { it.downloadUrl.await().toString() }

        val imgMaestros = storage.child("ic_maestro").listAll().await()
        listMaestros = imgMaestros.items.map { it.downloadUrl.await().toString() }

        val imgMaestras = storage.child("ic_maestra").listAll().await()
        listMaestras = imgMaestras.items.map { it.downloadUrl.await().toString() }
    }

    fun getAlumna() = listAlumnas.randomOrNull()
    fun getAlumno() = listAlumnos.randomOrNull()
    fun getBuhito() = listBuhitos.randomOrNull()
    fun getMaestro() = listMaestros.randomOrNull()
    fun getMaestra() = listMaestras.randomOrNull()

}