package com.jjmf.elementaryschool.data.usecase

import com.jjmf.elementaryschool.data.repository.ImagenesRepository
import javax.inject.Inject

class Imagenes @Inject constructor(
    private val repository: ImagenesRepository
) {

    suspend fun cursos() = repository.getListImagen("ic_cursos")

}