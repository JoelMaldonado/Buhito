package com.jjmf.elementaryschool.data.repository

import com.jjmf.elementaryschool.core.EstadosResult
import com.jjmf.elementaryschool.data.interfaces.ApiInterface
import com.jjmf.elementaryschool.model.Curso
import javax.inject.Inject

interface CursoRepository {

    suspend fun insert(curso: Curso): EstadosResult<String>

    suspend fun delete(curso: Curso): EstadosResult<String>

    suspend fun getList(): EstadosResult<List<Curso>>
}

class CursoRepositoryImpl @Inject constructor(
    private val api: ApiInterface,
) : CursoRepository {

    override suspend fun insert(curso: Curso): EstadosResult<String> {
        return tryCall(
            call = api.insertCurso(curso)
        ){
            if (it.isSuccess) EstadosResult.Correcto(null)
            else EstadosResult.Error(it.message)
        }
    }

    override suspend fun getList(): EstadosResult<List<Curso>> {
        return tryCall(
            call = api.getListCurso()
        ) {
            if (it.isSuccess) EstadosResult.Correcto(it.data)
            else EstadosResult.Error(it.message)
        }
    }

    override suspend fun delete(curso: Curso): EstadosResult<String> {
        return tryCall(
            call = api.deleteCurso(curso.id)
        ) {
            if (it.isSuccess) {
                EstadosResult.Correcto(null)
            } else EstadosResult.Error(it.message)
        }
    }
}