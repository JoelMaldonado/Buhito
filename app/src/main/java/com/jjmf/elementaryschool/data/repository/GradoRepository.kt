package com.jjmf.elementaryschool.data.repository

import com.jjmf.elementaryschool.data.database.AppDataBase
import com.jjmf.elementaryschool.model.Grado
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GradoRepository {

    suspend fun insert(curso: Grado)

    suspend fun delete(curso: Grado)

    suspend fun getList(): Flow<List<Grado>>
}

class GradoRespositoryImpl @Inject constructor(
    private val db: AppDataBase
) : GradoRepository {

    override suspend fun insert(curso: Grado) {
        db.gradoDao().insert(curso)
    }

    override suspend fun getList(): Flow<List<Grado>> {
        return db.gradoDao().getList()
    }

    override suspend fun delete(curso: Grado) {
        db.gradoDao().delete(curso)
    }
}