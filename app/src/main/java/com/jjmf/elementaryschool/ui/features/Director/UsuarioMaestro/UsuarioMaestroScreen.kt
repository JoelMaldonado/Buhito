package com.jjmf.elementaryschool.ui.features.Director.UsuarioMaestro

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jjmf.elementaryschool.util.Recursos

@Composable
fun UsuarioMaestroScreen(
    toAgregarUsuario:()->Unit
) {

    Box(
        modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(10) {
                ItemUsuario()
            }
        }
        FloatingActionButton(
            onClick = toAgregarUsuario,
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = Color.White
        ) {
            Icon(imageVector = Icons.Default.PersonAdd, contentDescription = null)
        }
    }

}

@Composable
fun ItemUsuario() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {

            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Image(
            painter = painterResource(id = Recursos.getImgMaestro()),
            contentDescription = null,
            modifier = Modifier.size(70.dp)
        )
        Column {
            Text(text = "Nombre Profesor", fontWeight = FontWeight.Medium)
            Text(text = "Matematicas", fontSize = 14.sp, color = Color.Gray.copy(0.5f))
        }
    }
}
