package com.jjmf.elementaryschool.ui.features.Menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MenuScreen(
    toUsuario:()->Unit,
    toCurso:()->Unit,
) {
    
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = toUsuario
        ) {

            Text(text = "Usuarios")

        }
        Button(
            onClick = toCurso
        ) {

            Text(text = "Cursos")

        }
        
    }

}