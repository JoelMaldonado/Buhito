package com.jjmf.elementaryschool.ui.navigation

sealed class Rutas(val url: String) {
    object Login : Rutas(url = "login")
    object Menu : Rutas(url = "menu")
    object UsuarioMaestro : Rutas(url = "usuariomaestro")
    object AgregarUsuario : Rutas(url = "agregarusuario")
    object CursoMaestro : Rutas(url = "cursomaestro")
}
