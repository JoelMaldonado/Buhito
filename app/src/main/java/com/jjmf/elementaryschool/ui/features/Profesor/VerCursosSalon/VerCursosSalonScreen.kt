package com.jjmf.elementaryschool.ui.features.Profesor.VerCursosSalon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.theme.ColorHembra
import com.jjmf.elementaryschool.ui.theme.ColorP1
import com.jjmf.elementaryschool.ui.theme.ColorS1

@Composable
fun VerCursosSalonScreen(
    toAsignarNotas: () -> Unit,
    viewModel: VerCursosSalonViewModel = hiltViewModel(),
    back: () -> Unit
) {
    val listMaterias = viewModel.listMaterias.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Top(
            back = { back() },
            titulo = "Materias"
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(ColorP1)
                .clip(RoundedCornerShape(topEnd = 30.dp))
                .background(Color.White)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (listMaterias.isEmpty()) {
                item {
                    Text(
                        text = "Sin materias", modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp), textAlign = TextAlign.Center
                    )
                }
            } else {
                items(listMaterias) {
                    CardVerCurso(
                        toAsignarNotas = toAsignarNotas,
                        texto = it.detalle
                    )
                }
            }
        }
    }
}

@Composable
fun CardVerCurso(
    toAsignarNotas: () -> Unit,
    texto: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = texto,
                color = ColorP1,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(10.dp)
            )
            Divider()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Descripcion", fontSize = 14.sp, color = Color.Gray)
                Button(onClick = toAsignarNotas) {
                    Text(text = "Asignar Notas")
                }
            }
        }

    }
}
