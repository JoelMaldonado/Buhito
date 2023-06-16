package com.jjmf.elementaryschool.ui.features.Profesor.AsignarNotas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.theme.ColorP1

@Composable
fun AsignarNotasScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Top(back = {}, titulo = "Matematica")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            repeat(15){
                ItemAsignarNota(it+1)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemAsignarNota(n:Int) {
    val nota = remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(text = "$n. Joel Maldonado", modifier = Modifier.weight(2f))
        TextField(
            value = nota.value,
            onValueChange = {nota.value = it},
            placeholder = {
                Text(text = "Nota")
            },
            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent
            )
        )
    }
}
