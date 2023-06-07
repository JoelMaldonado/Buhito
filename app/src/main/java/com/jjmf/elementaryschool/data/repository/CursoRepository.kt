package com.jjmf.elementaryschool.data.repository

import com.jjmf.elementaryschool.data.database.AppDataBase
import com.jjmf.elementaryschool.model.Curso
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CursoRepository {

    suspend fun insert(curso: Curso)

    suspend fun delete(curso: Curso)

    suspend fun getListFlow(): Flow<List<Curso>>
}

class CursoRepositoryImpl @Inject constructor(
    private val db: AppDataBase
) : CursoRepository {

    override suspend fun insert(curso: Curso) {
        db.cursoDao().insert(curso)
    }

    override suspend fun getListFlow(): Flow<List<Curso>> {
        return db.cursoDao().getList()
    }

    override suspend fun delete(curso: Curso) {
        db.cursoDao().delete(curso)
    }
}