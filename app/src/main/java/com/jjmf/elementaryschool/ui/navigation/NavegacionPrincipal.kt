package com.jjmf.elementaryschool.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjmf.elementaryschool.ui.features.Login.LoginScreen
import com.jjmf.elementaryschool.ui.features.Profesor.MenuProfesorScreen

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
                        "P" -> navController.navigate(Rutas.MenuDirector.url)
                        "D" -> navController.navigate(Rutas.MenuDirector.url)
                    }
                }
            )
        }

        composable(Rutas.MenuAlumno.url) {
            Text(text = "Alumno")
        }

        composable(Rutas.MenuProfesor.url) {
            MenuProfesorScreen()
        }

        composable(Rutas.MenuDirector.url) {
            NavegacionDirector()
        }

    }
}