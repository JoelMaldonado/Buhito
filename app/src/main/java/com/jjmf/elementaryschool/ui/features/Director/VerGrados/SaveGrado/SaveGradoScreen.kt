package com.jjmf.elementaryschool.ui.features.Director.VerGrados.SaveGrado

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.elementaryschool.ui.components.CajaTexto
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.theme.ColorP1
import com.jjmf.elementaryschool.ui.theme.ColorS1
import com.jjmf.elementaryschool.ui.theme.ColorT1

@Composable
fun SaveGradoScreen(
    back: () -> Unit,
    viewModel: SaveGradoViewModel = hiltViewModel(),
) {
    if (viewModel.back) {
        LaunchedEffect(key1 = Unit) {
            back()
            viewModel.back = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Top(
            back = back,
            titulo = "Añadir Grado"
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(ColorP1)
                .clip(RoundedCornerShape(topEnd = 30.dp))
                .background(Color.White)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                CajaTexto(
                    modifier = Modifier.weight(1f),
                    valor = viewModel.detalle,
                    newValor = {
                        viewModel.detalle = it
                    },
                    label = "Nombre del Grado",
                    placeholder = "Ej. 3",
                    keyboardType = KeyboardType.Number
                )

                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(ColorT1),
                    contentAlignment = Alignment.Center
                ) {
                    if (viewModel.detalle.isEmpty()) {
                        Icon(
                            imageVector = Icons.Default.QuestionMark,
                            contentDescription = null,
                            tint = Color.White
                        )
                    } else {

                        val primero = viewModel.detalle[0].uppercase()
                        val segundo = if (viewModel.seccion.isNotEmpty()) viewModel.seccion.first().uppercase() else ""

                        Text(
                            text =  primero + segundo,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 24.sp
                        )
                    }
                }
            }

            CajaTexto(
                modifier = Modifier.fillMaxWidth(),
                valor = viewModel.seccion,
                newValor = {
                    viewModel.seccion = it
                },
                label = "Sección (opcional)",
                placeholder = "Ej. A"
            )

            Spacer(modifier = Modifier.weight(1f))


            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = viewModel::insertarCurso,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorS1
                )
            ) {
                Text(text = "Guardar", fontSize = 18.sp)
            }
        }
    }
}