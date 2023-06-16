package com.jjmf.elementaryschool.ui.features.Alumno.VerNotas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jjmf.elementaryschool.ui.theme.ColorP2

@Composable
fun VerNotasScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        repeat(5) {
            CardNotas()
        }

    }
}

@Composable
fun CardNotas() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 15.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Matematicas",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ColorP2)
                    .padding(10.dp),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ColorP2.copy(0.5f))
                    .padding(5.dp)
            ) {

                Text(
                    text = "Descripcion",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(2f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Nota",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Fecha",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )

            }
            repeat(4) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp)
                ) {

                    Text(
                        text = "Nota ${it+1}°",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(2f),
                        fontSize = 14.sp
                    )
                    Text(
                        text = "16",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f),
                        fontSize = 14.sp
                    )
                    Text(
                        text = "18/03/23",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f),
                        fontSize = 14.sp
                    )

                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ColorP2.copy(0.5f))
            ) {

                Text(
                    text = "Promedio Final",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(2f).padding(5.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "16",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(2f)
                        .background(ColorP2)
                        .padding(5.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )

            }

        }

    }
}
