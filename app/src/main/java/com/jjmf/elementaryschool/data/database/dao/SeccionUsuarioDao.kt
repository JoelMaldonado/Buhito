package com.jjmf.elementaryschool.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.jjmf.elementaryschool.model.SeccionUsuario
import kotlinx.coroutines.flow.Flow

@Dao
interface SeccionUsuarioDao {

    @Query("select * from tb_seccionusuario")
    fun getList() : Flow<List<SeccionUsuario>>
}