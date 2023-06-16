package com.jjmf.elementaryschool.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjmf.elementaryschool.ui.features.Alumno.MenuAlumnoScreen
import com.jjmf.elementaryschool.ui.features.Alumno.VerNotas.VerNotasScreen
import com.jjmf.elementaryschool.ui.features.Profesor.AsignarNotas.AsignarNotasScreen
import com.jjmf.elementaryschool.ui.features.Profesor.MenuProfesorScreen
import com.jjmf.elementaryschool.ui.features.Profesor.VerCursosSalon.VerCursosSalonScreen

@Composable
fun NavegacionProfesor() {

    val context = LocalContext.current
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.MenuProfesor.url) {
        composable(Rutas.MenuProfesor.url) {
            MenuProfesorScreen(
                toCursos = {
                    navController.navigate(Rutas.VerCursosSalon.url)
                }
            )
        }

        composable(Rutas.VerCursosSalon.url){
            VerCursosSalonScreen(
                toAsignarNotas = {
                    navController.navigate(Rutas.AsignarNotas.url)
                }
            )
        }

        composable(Rutas.AsignarNotas.url){
            AsignarNotasScreen()
        }
    }
}