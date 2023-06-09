package com.jjmf.elementaryschool.data.repository

import com.jjmf.elementaryschool.data.database.AppDataBase
import com.jjmf.elementaryschool.model.Seccion
import com.jjmf.elementaryschool.model.SeccionUsuario
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface SeccionRepository {

    suspend fun insert(seccion: Seccion)
    suspend fun delete(seccion: Seccion)
    suspend fun getList(grado: Int): List<Seccion>
    suspend fun getListFlow(grado: Int): Flow<List<Seccion>>
    suspend fun deleteAll(grado:Int)
}

class SeccionRepositoryImpl @Inject constructor(
    private val db: AppDataBase
) : SeccionRepository {

    override suspend fun insert(seccion: Seccion) {

        db.seccionDao().insert(seccion)

    }

    override suspend fun delete(seccion: Seccion) {
        db.seccionDao().delete(seccion)
    }

    override suspend fun getList(grado: Int): List<Seccion> {
        return if (grado == 0) db.seccionDao().getListAll()
        else db.seccionDao().getList(grado)
    }

    override suspend fun getListFlow(grado: Int): Flow<List<Seccion>> {
        return if (grado == 0) db.seccionDao().getListAllFlow()
        else db.seccionDao().getListFlow(grado)
    }

    override suspend fun deleteAll(grado:Int) {
        db.seccionDao().deleteAll(grado)
    }

}