package com.jjmf.elementaryschool.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jjmf.elementaryschool.data.database.dao.CursoDao
import com.jjmf.elementaryschool.data.database.dao.SeccionDao
import com.jjmf.elementaryschool.data.database.dao.UsuarioDao
import com.jjmf.elementaryschool.model.Curso
import com.jjmf.elementaryschool.model.Seccion
import com.jjmf.elementaryschool.model.Usuario

@Database(
    entities = [
        Usuario::class,
        Curso::class,
        Seccion::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun cursoDao(): CursoDao
    abstract fun seccionDao(): SeccionDao
}