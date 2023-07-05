package com.jjmf.elementaryschool.data.module

import android.content.Context
import androidx.room.Room
import com.jjmf.elementaryschool.data.database.AppDataBase
import com.jjmf.elementaryschool.data.database.dao.SeccionUsuarioDao
import com.jjmf.elementaryschool.util.Constantes.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesRoom(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideSeccionUsuario(db: AppDataBase): SeccionUsuarioDao {
        return db.seccionUsuarioDao()
    }

}