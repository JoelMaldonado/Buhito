package com.jjmf.elementaryschool.ui.features.Director.AgregarUsuario

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.elementaryschool.R
import com.jjmf.elementaryschool.ui.components.CajaTexto
import com.jjmf.elementaryschool.ui.theme.ColorAlumno
import com.jjmf.elementaryschool.ui.theme.ColorHembra
import com.jjmf.elementaryschool.ui.theme.ColorMacho
import com.jjmf.elementaryschool.ui.theme.ColorProfesor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgregarUsuarioScreen(
    back: () -> Unit,
    viewModel: AgregarUsuarioViewModel = hiltViewModel(),
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBar(
            title = {
                Text(text = "Añadir Usuario", fontWeight = FontWeight.Medium, color = Color.White)
            },
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            navigationIcon = {
                IconButton(onClick = back) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                }
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CajaTexto(
                valor = viewModel.nombre,
                newValor = {
                    viewModel.nombre = it
                },
                label = "Nombres y apellidos"
            )
            CajaTexto(
                valor = viewModel.correo,
                newValor = {
                    viewModel.correo = it
                },
                label = "Correo electronico"
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = (R.drawable.ic_profesor)),
                    contentDescription = null,
                    tint = ColorProfesor
                )
                Switch(
                    checked = viewModel.tipo,
                    onCheckedChange = {
                        viewModel.tipo = it
                    },
                    colors = SwitchDefaults.colors(
                        checkedTrackColor = ColorAlumno.copy(0.5f),
                        checkedThumbColor = ColorAlumno,
                        uncheckedTrackColor = ColorProfesor.copy(0.5f),
                        uncheckedThumbColor = ColorProfesor,
                        uncheckedBorderColor = Color.Transparent,
                        checkedBorderColor = Color.Transparent
                    )
                )
                Icon(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = (R.drawable.ic_alumno)),
                    contentDescription = null,
                    tint = ColorAlumno
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Default.Male,
                    contentDescription = null,
                    tint = ColorMacho
                )
                Switch(
                    checked = viewModel.genero,
                    onCheckedChange = {
                        viewModel.genero = it
                    },
                    colors = SwitchDefaults.colors(
                        checkedTrackColor = ColorHembra.copy(0.5f),
                        checkedThumbColor = ColorHembra,
                        uncheckedTrackColor = ColorMacho.copy(0.5f),
                        uncheckedThumbColor = ColorMacho,
                        uncheckedBorderColor = Color.Transparent,
                        checkedBorderColor = Color.Transparent
                    )
                )
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Default.Female,
                    contentDescription = null,
                    tint = ColorHembra
                )

            }
            Button(
                onClick = {

                }
            ) {
                Text(text = "Guardar")
            }
        }
    }

}