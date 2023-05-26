package com.jjmf.elementaryschool.data.repository

import com.jjmf.elementaryschool.data.database.AppDataBase
import com.jjmf.elementaryschool.model.Usuario
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface UsuarioRepository {
    suspend fun insert(usuario: Usuario)
    suspend fun getList() : Flow<List<Usuario>>
    suspend fun delete(usuario: Usuario)
}

class UsuarioRepositoryImpl @Inject constructor(
    private val db: AppDataBase
) : UsuarioRepository {
    override suspend fun insert(usuario: Usuario) {
        db.usuarioDao().insert(usuario)
    }

    override suspend fun getList(): Flow<List<Usuario>> {
        return db.usuarioDao().getList()
    }

    override suspend fun delete(usuario: Usuario) {
        db.usuarioDao().delete(usuario)
    }

}