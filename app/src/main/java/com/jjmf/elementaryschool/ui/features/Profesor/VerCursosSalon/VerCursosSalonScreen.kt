package com.jjmf.elementaryschool.ui.features.Profesor.VerCursosSalon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.theme.ColorP1

@Composable
fun VerCursosSalonScreen(
    toAsignarNotas: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Top(back = {}, titulo = "Cursos")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            repeat(5) {

                CardVerCurso(
                    toAsignarNotas = toAsignarNotas
                )
            }
        }

    }

}

@Composable
fun CardVerCurso(
    toAsignarNotas:()->Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Matematica",
                color = ColorP1,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(10.dp)
            )
            Divider()
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Descripcion", fontSize = 12.sp, color = Color.Gray)
                Button(onClick = toAsignarNotas) {
                    Text(text = "Asignar Notas")
                }
            }
        }

    }
}
