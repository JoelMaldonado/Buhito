package com.jjmf.elementaryschool.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jjmf.elementaryschool.model.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuario: Usuario)

    @Query("select * from tb_usuario")
    fun getList(): Flow<List<Usuario>>

    @Update
    suspend fun update(user: Usuario)

    @Delete
    suspend fun delete(user: Usuario)

}