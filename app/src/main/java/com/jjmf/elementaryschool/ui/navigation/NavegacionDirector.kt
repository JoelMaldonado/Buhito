package com.jjmf.elementaryschool.ui.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jjmf.elementaryschool.ui.features.Director.MenuDirectorScreen
import com.jjmf.elementaryschool.ui.features.Director.VerCursos.SaveCurso.SaveCursoScreen
import com.jjmf.elementaryschool.ui.features.Director.VerCursos.CursoMaestroScreen
import com.jjmf.elementaryschool.ui.features.Director.VerGrados.VerGradosScreen
import com.jjmf.elementaryschool.ui.features.Director.VerGrados.VerSalon.VerSalonScreen
import com.jjmf.elementaryschool.ui.features.Director.VerGrados.VerSecciones.VerSeccionesScreen
import com.jjmf.elementaryschool.ui.features.Director.VerProfesores.AddEditProfesor.AddEditProfesorScreen
import com.jjmf.elementaryschool.ui.features.Director.VerProfesores.AsignarCurso.AsignarCursosScreen
import com.jjmf.elementaryschool.ui.features.Director.VerProfesores.VerProfesoresScreen

@Composable
fun NavegacionDirector() {

    val context = LocalContext.current
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.MenuDirector.url) {
        composable(Rutas.MenuDirector.url) {

            MenuDirectorScreen(
                toProfesor = {
                    navController.navigate(Rutas.VerProfesores.url)
                },
                toCurso = {
                    navController.navigate(Rutas.VerCursos.url)
                },
                toGrado = {
                    navController.navigate(Rutas.VerGrados.url)
                }
            )
        }


        composable(Rutas.VerProfesores.url) {
            VerProfesoresScreen(
                back = {
                    navController.popBackStack()
                },
                toAgregarProfesor = {
                    navController.navigate(Rutas.AgregarProfesor.url)
                },
                toEditarProfesor = { id ->
                    navController.navigate(Rutas.EditarProfesor.sendId(id))
                }
            )
        }

        /**Agregar Profesor**/
        composable(Rutas.AgregarProfesor.url) {
            AddEditProfesorScreen(
                back = {
                    navController.popBackStack()
                },
                toAsignar = {idRpta->
                    navController.popBackStack()
                    navController.navigate(Rutas.AsignarCurso.sendId(idRpta))
                }
            )
        }
        /**Editar Profesor**/
        composable(
            route = Rutas.EditarProfesor.url,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("id")
            if (id != null) {
                AddEditProfesorScreen(
                    id = id,
                    back = {
                        navController.popBackStack()
                    },
                    toAsignar = {idRpta->
                        navController.navigate(Rutas.AsignarCurso.sendId(idRpta))
                    }
                )
            } else {
                Toast.makeText(context, "Ruta no encontrada", Toast.LENGTH_SHORT).show()
                navController.popBackStack()
            }
        }

        composable(
            route = Rutas.AsignarCurso.url,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("id")
            if (id != null) {
                AsignarCursosScreen(
                    id = id,
                    back = {
                        navController.popBackStack()
                    }
                )
            } else {
                Toast.makeText(context, "Ruta no encontrada", Toast.LENGTH_SHORT).show()
                navController.popBackStack()
            }
        }


        /**Ver Cursos**/
        composable(Rutas.VerCursos.url) {
            CursoMaestroScreen(
                back = {
                    navController.popBackStack()
                },
                toAgregarCurso = {
                    navController.navigate(Rutas.AgregarCurso.url)
                }
            )
        }

        /**Editar Curso**/
        composable(Rutas.AgregarCurso.url) {
            SaveCursoScreen(
                back = {
                    navController.popBackStack()
                }
            )
        }

        composable(Rutas.VerGrados.url) {
            VerGradosScreen(
                back = {
                    navController.popBackStack()
                },
                toVerSecciones = { grado ->
                    navController.navigate(Rutas.VerSecciones.sendGrado(grado))
                }
            )
        }

        composable(
            route = Rutas.VerSecciones.url,
            arguments = listOf(
                navArgument("grado") {
                    type = NavType.IntType
                }
            )
        ) {
            val grado = it.arguments?.getInt("grado")!!
            VerSeccionesScreen(
                grado = grado,
                toVerSalon = { id ->
                    navController.navigate(Rutas.VerSalon.sendId(id))
                },
                back = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Rutas.VerSalon.url,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {

            val id = it.arguments?.getInt("id")!!
            VerSalonScreen(
                idSeccion = id,
                back = {
                    navController.popBackStack()
                }
            )

        }
    }
}