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
    object AsignarCurso : Rutas(url = "asignar_curso?{id}"){
        fun sendId(id:Int) = "asignar_curso?$id"
    }
    object VerCursos : Rutas(url = "ver_cursos")
    object AgregarCurso : Rutas(url = "agregar_curso")
    object EditarCurso : Rutas(url = "editar_curso?{id}"){
        fun sendId(id:Int) = "editar_curso?$id"
    }
    object VerGrados : Rutas(url = "vergrado")
    object VerSecciones : Rutas(url = "ver_secciones?{grado}"){
        fun sendGrado(grado:Int) = "ver_secciones?$grado"
    }
    object VerSalon : Rutas(url = "ver_salon?{id}"){
        fun sendId(id:Int) = "ver_salon?$id"
    }
}
