package com.jjmf.elementaryschool.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjmf.elementaryschool.ui.features.Alumno.MenuAlumnoScreen
import com.jjmf.elementaryschool.ui.features.Alumno.VerNotas.VerNotasScreen

@Composable
fun NavegacionAlumno() {

    val context = LocalContext.current
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.MenuAlumno.url) {
        composable(Rutas.MenuAlumno.url) {
            MenuAlumnoScreen(
                toVerNotas = {
                    navController.navigate(Rutas.VerNotasAlumno.url)
                }
            )
        }

        composable(Rutas.VerNotasAlumno.url){
            VerNotasScreen()
        }
    }
}