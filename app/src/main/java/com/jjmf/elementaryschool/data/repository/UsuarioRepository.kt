package com.jjmf.elementaryschool.data.repository

import com.jjmf.elementaryschool.core.EstadosResult
import com.jjmf.elementaryschool.data.interfaces.ApiInterface
import com.jjmf.elementaryschool.model.Usuario
import com.jjmf.elementaryschool.model.Wrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

interface UsuarioRepository {
    suspend fun insert(usuario: Usuario)
    suspend fun getListFlow(): Flow<List<Usuario>>
    suspend fun getList(): List<Usuario>
    suspend fun listarUsuarios(): EstadosResult<List<Usuario>>
    suspend fun delete(usuario: Usuario)
}

class UsuarioRepositoryImpl @Inject constructor(
    private val api: ApiInterface,
) : UsuarioRepository {
    override suspend fun insert(usuario: Usuario) {
        //db.insert(usuario)
    }

    override suspend fun getListFlow(): Flow<List<Usuario>> = flow{
        emit(emptyList())
    }

    override suspend fun getList(): List<Usuario> {
        return emptyList()
    }

    override suspend fun listarUsuarios(): EstadosResult<List<Usuario>> {
        return tryCall(
            call = api.getListUser(),
            body = {
                if (it.isSuccess){
                    EstadosResult.Correcto(it.data)
                }else{
                    EstadosResult.Error(it.message)
                }
            }
        )
    }

    override suspend fun delete(usuario: Usuario) {
        //db.delete(usuario)
    }

}

fun <T> tryCall(call: Response<Wrapper<T>>, body: (Wrapper<T>) -> EstadosResult<T>): EstadosResult<T> {
    return try {
        if (call.isSuccessful) {
            if (call.body() != null) body(call.body()!!)
            else EstadosResult.Error("Error al obtener información")
        } else EstadosResult.Error(call.message())
    } catch (e: Exception) {
        EstadosResult.Error(e.message.toString())
    }
}