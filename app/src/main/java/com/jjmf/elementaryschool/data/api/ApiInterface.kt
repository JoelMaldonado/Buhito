package com.jjmf.elementaryschool.data.api

import com.jjmf.elementaryschool.model.Curso
import com.jjmf.elementaryschool.model.Usuario
import com.jjmf.elementaryschool.model.Wrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {


    @GET("api/usuario")
    suspend fun getListUser(): Response<Wrapper<List<Usuario>>>

    @GET("api/curso")
    suspend fun getListCurso() : Response<Wrapper<List<Curso>>>

    @POST("api/curso")
    suspend fun insertCurso(@Body curso: Curso) : Response<Wrapper<Nothing>>

    @DELETE("api/curso/{id}")
    suspend fun deleteCurso(@Path("id")id:Int) : Response<Wrapper<Nothing>>

}