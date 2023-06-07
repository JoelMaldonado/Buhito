package com.jjmf.elementaryschool.ui.features.Director.VerProfesores.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.jjmf.elementaryschool.model.Grado
import com.jjmf.elementaryschool.ui.components.CajaBuscar

@Composable
fun AlertAsignarGrado(
    list: List<Grado>,
    dismiss: () -> Unit,
    click:(String)->Unit
) {

    Dialog(onDismissRequest = dismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = "Asignar Grado", fontWeight = FontWeight.Medium, fontSize = 18.sp)
                IconButton(onClick = dismiss) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                }
            }

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(list) {
                    Text(
                        text = "Grado ${it.detalle} - Sección ${it.seccion}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { click("Grado ${it.detalle} - Sección ${it.seccion}") }
                            .padding(10.dp)
                    )
                    Divider()
                }
                item {
                    Text(
                        text = "Sin Asignar",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { click("Sin Asignar") }
                            .padding(10.dp)
                    )
                }
            }
        }
    }
}