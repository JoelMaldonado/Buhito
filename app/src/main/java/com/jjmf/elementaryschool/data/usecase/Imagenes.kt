package com.jjmf.elementaryschool.data.usecase

import com.jjmf.elementaryschool.data.repository.ImagenesRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class Imagenes @Inject constructor(
    private val repository: ImagenesRepository
) {

    suspend fun cursos() = repository.getListImagen("ic_cursos")
    suspend fun alumnas() = repository.getListImagen("ic_alumnas")
    suspend fun alumnos() = repository.getListImagen("ic_alumnos")
    suspend fun buhitos() = repository.getListImagen("ic_buhito")
    suspend fun maestros() = repository.getListImagen("ic_maestro")
    suspend fun maestras() = repository.getListImagen("ic_maestra")

}