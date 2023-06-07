package com.jjmf.elementaryschool.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jjmf.elementaryschool.model.Curso
import kotlinx.coroutines.flow.Flow

@Dao
interface CursoDao {

    @Insert
    suspend fun insert(curso: Curso)

    @Query("select * from tb_curso")
    fun getList(): Flow<List<Curso>>

    @Delete
    suspend fun delete(curso: Curso)

    @Update
    suspend fun update(curso: Curso)
}