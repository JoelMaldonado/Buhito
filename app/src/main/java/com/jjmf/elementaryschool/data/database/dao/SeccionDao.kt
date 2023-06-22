package com.jjmf.elementaryschool.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jjmf.elementaryschool.model.Seccion
import com.jjmf.elementaryschool.model.SeccionUsuario
import kotlinx.coroutines.flow.Flow
@Dao
interface SeccionDao {
    @Insert
    suspend fun insert(seccion: Seccion)

    @Query("select * from tb_seccion")
    fun getListAll(): List<Seccion>

    @Query("select * from tb_seccion where grado = :grado")
    fun getList(grado: Int): List<Seccion>

    @Query("select * from tb_seccion")
    fun getListAllFlow(): Flow<List<Seccion>>

    @Query("select * from tb_seccion where grado = :grado")
    fun getListFlow(grado: Int): Flow<List<Seccion>>

    @Delete
    suspend fun delete(seccion: Seccion)

    @Update
    suspend fun update(seccion: Seccion)

    @Query("delete from tb_seccion where grado = :grado")
    fun deleteAll(grado:Int)
}