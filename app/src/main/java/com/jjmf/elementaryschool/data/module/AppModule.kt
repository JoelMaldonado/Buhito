package com.jjmf.elementaryschool.data.module

import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import com.jjmf.elementaryschool.data.usecase.Login.SignInUseCase
import com.jjmf.elementaryschool.data.usecase.Login.ValidateClaveUseCase
import com.jjmf.elementaryschool.data.usecase.Login.ValidateCorreoUseCase
import com.jjmf.elementaryschool.data.usecase.LoginUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUseCaseLogin(repository: UsuarioRepository) : LoginUsecase {
        return LoginUsecase(
            validateCorreoUseCase = ValidateCorreoUseCase(),
            validateClaveUseCase = ValidateClaveUseCase(),
            signIn = SignInUseCase(repository)
        )
    }
}