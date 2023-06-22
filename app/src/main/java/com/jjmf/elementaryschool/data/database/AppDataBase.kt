package com.jjmf.elementaryschool.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jjmf.elementaryschool.data.database.dao.CalificacionesDao
import com.jjmf.elementaryschool.data.database.dao.CursoDao
import com.jjmf.elementaryschool.data.database.dao.SeccionDao
import com.jjmf.elementaryschool.data.database.dao.SeccionUsuarioDao
import com.jjmf.elementaryschool.data.database.dao.UsuarioDao
import com.jjmf.elementaryschool.model.Calificacion
import com.jjmf.elementaryschool.model.Curso
import com.jjmf.elementaryschool.model.Seccion
import com.jjmf.elementaryschool.model.SeccionUsuario
import com.jjmf.elementaryschool.model.Usuario

@Database(
    entities = [
        Usuario::class,
        Curso::class,
        Seccion::class,
        SeccionUsuario::class,
        Calificacion::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun cursoDao(): CursoDao
    abstract fun seccionDao(): SeccionDao
    abstract fun seccionUsuarioDao(): SeccionUsuarioDao
    abstract fun calificacionesDao(): CalificacionesDao
}