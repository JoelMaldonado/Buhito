package com.jjmf.elementaryschool.data.repository

import com.jjmf.elementaryschool.data.database.AppDataBase
import com.jjmf.elementaryschool.data.database.dao.UsuarioDao
import com.jjmf.elementaryschool.model.Usuario
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface UsuarioRepository {
    suspend fun insert(usuario: Usuario)
    suspend fun getListFlow(): Flow<List<Usuario>>
    suspend fun getList(): List<Usuario>
    suspend fun delete(usuario: Usuario)
}

class UsuarioRepositoryImpl @Inject constructor(
    private val db: UsuarioDao,
) : UsuarioRepository {
    override suspend fun insert(usuario: Usuario) {
        db.insert(usuario)
    }

    override suspend fun getListFlow(): Flow<List<Usuario>> {
        return db.getListFlow()
    }

    override suspend fun getList(): List<Usuario> {
        return db.getList()
    }

    override suspend fun delete(usuario: Usuario) {
        db.delete(usuario)
    }

}