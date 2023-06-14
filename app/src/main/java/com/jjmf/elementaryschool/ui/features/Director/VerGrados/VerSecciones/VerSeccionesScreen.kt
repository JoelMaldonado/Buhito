package com.jjmf.elementaryschool.ui.features.Director.VerGrados.VerSecciones

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.theme.ColorS1

@Composable
fun VerSeccionesScreen(
    back:()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Top(
            back = back,
            titulo ="1° Grado",
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color.White)
                }
            }
        )

        Box(modifier = Modifier.fillMaxSize()){
            LazyColumn{
                item {
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(text = "Seccion A")

                        val texto = "Hola mundo"
                        
                    }
                }
            }

            FloatingActionButton(
                onClick = {},
                containerColor = ColorS1,
                contentColor = Color.White,
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Icon(imageVector = Icons.Default.School, contentDescription = null)
            }
        }

    }
}

