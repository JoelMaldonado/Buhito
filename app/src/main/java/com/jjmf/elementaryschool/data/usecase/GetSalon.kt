package com.jjmf.elementaryschool.data.usecase

import com.jjmf.elementaryschool.data.repository.SeccionUsuarioRepository
import com.jjmf.elementaryschool.model.SeccionUsuario
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSalon @Inject constructor(
    private val repository: SeccionUsuarioRepository
) {
    suspend operator fun invoke(idProfesor:Int) : Flow<List<SeccionUsuario>> = flow{
        repository.getList().collect(){
            emit(it.filter { it.idProfesor == idProfesor })
        }
    }
}