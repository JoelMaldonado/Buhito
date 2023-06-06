package com.jjmf.elementaryschool.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jjmf.elementaryschool.model.Grado
import kotlinx.coroutines.flow.Flow

@Dao
interface GradoDao {

    @Insert
    suspend fun insert(curso: Grado)

    @Query("select * from tb_grado")
    fun getList(): Flow<List<Grado>>

    @Delete
    suspend fun delete(curso: Grado)

    @Update
    suspend fun update(curso: Grado)
}