package com.jjmf.elementaryschool.data.repository

import com.jjmf.elementaryschool.data.database.AppDataBase
import com.jjmf.elementaryschool.model.Grado
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GradoRepository {

    suspend fun insert(grado: Grado)
    suspend fun delete(grado: Grado)
    suspend fun getListFlow(): Flow<List<Grado>>
}

class GradoRepositoryImpl @Inject constructor(
    private val db: AppDataBase
) : GradoRepository {
    override suspend fun insert(grado: Grado) {
        db.gradoDao().insert(grado)
    }

    override suspend fun delete(grado: Grado) {
        db.gradoDao().delete(grado)
    }

    override suspend fun getListFlow(): Flow<List<Grado>> {
        return db.gradoDao().getList()
    }

}