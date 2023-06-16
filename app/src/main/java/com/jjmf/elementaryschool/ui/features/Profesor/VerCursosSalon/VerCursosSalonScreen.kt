package com.jjmf.elementaryschool.ui.features.Profesor.VerCursosSalon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jjmf.elementaryschool.ui.components.Top

@Composable
fun VerCursosSalonScreen(
    toAsignarNotas:()->Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Top(back = {}, titulo = "Cursos")
        Column(
            modifier = Modifier.fillMaxSize().padding(30.dp)
        ) {

            Button(onClick = toAsignarNotas) {
                Text(text = "Asignar Notas")
            }
        }

    }

}