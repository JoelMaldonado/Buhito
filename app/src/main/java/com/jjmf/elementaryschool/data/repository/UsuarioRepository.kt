package com.jjmf.elementaryschool.data.repository

import com.jjmf.elementaryschool.data.database.AppDataBase
import javax.inject.Inject

interface UsuarioRepository {

}

class UsuarioRepositoryImpl @Inject constructor(
    private val db: AppDataBase
) : UsuarioRepository {

}