package com.jjmf.elementaryschool.data.repository

import com.jjmf.elementaryschool.data.database.AppDataBase
import com.jjmf.elementaryschool.data.database.dao.SeccionUsuarioDao
import com.jjmf.elementaryschool.model.SeccionUsuario
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface SeccionUsuarioRepository {
    suspend fun getList(): Flow<List<SeccionUsuario>>
}

class SeccionUsuarioRepositoryImpl @Inject constructor(
    private val db: SeccionUsuarioDao,
) : SeccionUsuarioRepository {
    override suspend fun getList(): Flow<List<SeccionUsuario>> {
        return db.getList()
    }

}