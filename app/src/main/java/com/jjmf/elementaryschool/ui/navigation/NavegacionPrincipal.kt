package com.jjmf.elementaryschool.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjmf.elementaryschool.ui.features.Login.LoginScreen
import com.jjmf.elementaryschool.ui.features.Menu.MenuScreen

@Composable
fun NavegacionPrincipal() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.Login.url
    ){

        composable(Rutas.Login.url){
            LoginScreen()
        }

        composable(Rutas.Menu.url){
            MenuScreen()
        }

    }
}