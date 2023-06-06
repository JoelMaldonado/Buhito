package com.jjmf.elementaryschool.data.module

import com.jjmf.elementaryschool.data.repository.GradoRepository
import com.jjmf.elementaryschool.data.repository.GradoRespositoryImpl
import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import com.jjmf.elementaryschool.data.repository.UsuarioRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun repoUsuario(repo: UsuarioRepositoryImpl) : UsuarioRepository

    @Binds
    abstract fun repoGrado(repo: GradoRespositoryImpl) : GradoRepository
}
