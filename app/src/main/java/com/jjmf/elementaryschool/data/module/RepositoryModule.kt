package com.jjmf.elementaryschool.data.module

import com.jjmf.elementaryschool.data.repository.CalificacionRepository
import com.jjmf.elementaryschool.data.repository.CalificacionRepositoryImpl
import com.jjmf.elementaryschool.data.repository.CursoRepository
import com.jjmf.elementaryschool.data.repository.CursoRepositoryImpl
import com.jjmf.elementaryschool.data.repository.SeccionRepository
import com.jjmf.elementaryschool.data.repository.SeccionRepositoryImpl
import com.jjmf.elementaryschool.data.repository.SeccionUsuarioRepository
import com.jjmf.elementaryschool.data.repository.SeccionUsuarioRepositoryImpl
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
    abstract fun repoSeccion(repo: SeccionRepositoryImpl) : SeccionRepository

    @Binds
    abstract fun repoSeccionUsuario(repo: SeccionUsuarioRepositoryImpl) : SeccionUsuarioRepository

    @Binds
    abstract fun repoCalificacion(repo: CalificacionRepositoryImpl) : CalificacionRepository
}
