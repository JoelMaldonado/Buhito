package com.jjmf.elementaryschool.ui.features.Director.VerGrados.VerSalon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.elementaryschool.R
import com.jjmf.elementaryschool.ui.components.ItemMaestro
import com.jjmf.elementaryschool.ui.components.Top

@Composable
fun VerSalonScreen(
    idSeccion: Int,
    back: () -> Unit,
    viewModel: VerSalonViewModel = hiltViewModel(),
) {

    LaunchedEffect(key1 = Unit){
        viewModel.getDatos()
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Top(
            back = back,
            titulo = "1° Grado - Seccion A"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Profesor: Joel Maldonado")
                    Text(text = "Cantidad: 15 Alumnos")
                }

                Image(
                    painter = painterResource(id = R.drawable.buho_3),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ){
                items(15){
                    ItemMaestro(
                        img = R.drawable.alumno_2,
                        titulo = "Ignacio Casas",
                        descrip = "Se unio el 10/10/2008",
                        size = 50.dp
                    )
                }
            }
        }
    }
}