package com.jjmf.elementaryschool.data.repository

import com.jjmf.elementaryschool.data.database.AppDataBase
import javax.inject.Inject

interface CalificacionRepository {

}

class CalificacionRepositoryImpl @Inject constructor(
    private val db:AppDataBase
) : CalificacionRepository{

}