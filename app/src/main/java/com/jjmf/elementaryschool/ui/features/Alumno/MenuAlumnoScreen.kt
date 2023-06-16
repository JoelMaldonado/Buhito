package com.jjmf.elementaryschool.ui.features.Alumno

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MenuAlumnoScreen(
    toVerNotas:()->Unit
) {
    Column(

    ) {
        Button(onClick = toVerNotas) {
            Text(text = "Ver Notas")
        }
    }
}