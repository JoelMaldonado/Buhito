package com.jjmf.elementaryschool.ui.navigation

sealed class Rutas(val url: String) {
    object Login : Rutas(url = "login")
    object MenuAlumno : Rutas(url = "menu_alumno")
    object MenuProfesor : Rutas(url = "menu_profesor")


    /**Rutas del Director**/
    object MenuDirector : Rutas(url = "menu_director")
    object VerProfesores : Rutas(url = "ver_profesores")
    object AgregarProfesor : Rutas(url = "agregar_profesor")
    object EditarProfesor : Rutas(url = "editar_profesor?{id}"){
        fun sendId(id:Int) = "editar_profesor?$id"
    }
    object VerCursos : Rutas(url = "ver_cursos")
    object AgregarCurso : Rutas(url = "agregar_curso")
    object EditarCurso : Rutas(url = "editar_curso?{id}"){
        fun sendId(id:Int) = "editar_curso?$id"
    }
    object VerGrados : Rutas(url = "vergrado")
    object AgregarGrado : Rutas(url = "agregar_grado")
    object EditarGrado : Rutas(url = "editar_grado?{id}"){
        fun sendId(id:Int) = "editar_grado?$id"
    }
}
