package com.jjmf.elementaryschool.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjmf.elementaryschool.ui.features.Director.AgregarCurso.AgregarCursoScreen
import com.jjmf.elementaryschool.ui.features.Director.AgregarUsuario.AgregarUsuarioScreen
import com.jjmf.elementaryschool.ui.features.Director.CursoMaestro.CursoMaestroScreen
import com.jjmf.elementaryschool.ui.features.Director.UsuarioMaestro.UsuarioMaestroScreen
import com.jjmf.elementaryschool.ui.features.Login.LoginScreen
import com.jjmf.elementaryschool.ui.features.Menu.MenuScreen

@Composable
fun NavegacionPrincipal() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.Login.url
    ) {

        composable(Rutas.Login.url) {
            LoginScreen(
                toMenuDirector = {
                    navController.navigate(Rutas.Menu.url)
                }
            )
        }

        composable(Rutas.Menu.url) {
            MenuScreen(
                toUsuario = {
                    navController.navigate(Rutas.UsuarioMaestro.url)
                },
                toCurso = {
                    navController.navigate(Rutas.CursoMaestro.url)
                }
            )
        }

        composable(Rutas.UsuarioMaestro.url) {
            UsuarioMaestroScreen(
                back = {
                    navController.popBackStack()
                },
                toAgregarUsuario = {
                    navController.navigate(Rutas.AgregarUsuario.url)
                }
            )
        }

        composable(Rutas.AgregarUsuario.url) {
            AgregarUsuarioScreen(
                back = {
                    navController.popBackStack()
                }
            )
        }

        composable(Rutas.CursoMaestro.url) {
            CursoMaestroScreen(
                back = {
                    navController.popBackStack()
                },
                toAgregarCurso = {
                    navController.navigate(Rutas.AgregaCurso.url)
                }
            )
        }
        composable(Rutas.AgregaCurso.url){
            AgregarCursoScreen(
                back = {
                    navController.popBackStack()
                }
            )
        }

    }
}