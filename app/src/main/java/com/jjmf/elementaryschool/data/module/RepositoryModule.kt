package com.jjmf.elementaryschool.data.module

import com.jjmf.elementaryschool.data.repository.CursoRepository
import com.jjmf.elementaryschool.data.repository.CursoRepositoryImpl
import com.jjmf.elementaryschool.data.repository.GradoRepository
import com.jjmf.elementaryschool.data.repository.GradoRepositoryImpl
import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import com.jjmf.elementaryschool.data.repository.UsuarioRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun repoUsuario(repo: UsuarioRepositoryImpl) : UsuarioRepository

    @Binds
    abstract fun repoCurso(repo: CursoRepositoryImpl) : CursoRepository

    @Binds
    abstract fun repoGrado(repo: GradoRepositoryImpl) : GradoRepository
}
