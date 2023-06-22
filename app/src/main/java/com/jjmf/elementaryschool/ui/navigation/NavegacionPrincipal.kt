package com.jjmf.elementaryschool.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjmf.elementaryschool.ui.features.Login.LoginScreen

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
                    when (it) {
                        "A" -> navController.navigate(Rutas.MenuAlumno.url)
                        "P" -> navController.navigate(Rutas.MenuProfesor.url)
                        "D" -> navController.navigate(Rutas.MenuDirector.url)
                    }
                }
            )
        }

        composable(Rutas.MenuAlumno.url) {
            NavegacionAlumno()
        }

        composable(Rutas.MenuProfesor.url) {
            NavegacionProfesor()
        }

        composable(Rutas.MenuDirector.url) {
            NavegacionDirector()
        }

    }
}