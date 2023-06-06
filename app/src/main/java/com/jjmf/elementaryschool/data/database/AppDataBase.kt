package com.jjmf.elementaryschool.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jjmf.elementaryschool.data.database.dao.GradoDao
import com.jjmf.elementaryschool.data.database.dao.UsuarioDao
import com.jjmf.elementaryschool.model.Grado
import com.jjmf.elementaryschool.model.Usuario

@Database(
    entities = [Usuario::class,Grado::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase(){
    abstract fun usuarioDao() : UsuarioDao
    abstract fun gradoDao(): GradoDao
}