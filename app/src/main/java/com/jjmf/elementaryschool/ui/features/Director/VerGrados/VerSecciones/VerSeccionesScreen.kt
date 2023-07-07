package com.jjmf.elementaryschool.ui.features.Director.VerGrados.VerSecciones

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.elementaryschool.ui.components.ItemMaestro
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.features.Director.VerProfesores.alertEliminar
import com.jjmf.elementaryschool.ui.theme.ColorS1
import com.jjmf.elementaryschool.util.show

@Composable
fun VerSeccionesScreen(
    grado: Int,
    back: () -> Unit,
    toVerSalon: (Int) -> Unit,
    viewModel: VerSeccionesViewModel = hiltViewModel(),
) {

    val list = viewModel.list.collectAsState().value

    val context = LocalContext.current
    LaunchedEffect(key1 = Unit) {
        viewModel.getList(grado)
    }

    viewModel.error?.let {
        context.show(it)
        viewModel.error = null
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Top(
            back = back,
            titulo = "$grado° Grado - Secciones",
            trailingIcon = {
                IconButton(
                    onClick = {
                        viewModel.deleteAll(grado)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null,
                        tint = ColorS1
                    )
                }
            }
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(Modifier.fillMaxSize()){
                items(list){
                    ItemMaestro(
                        img = "",
                        init = "${it.grado}${it.detalle}",
                        titulo = "Grado ${it.grado} - Seccion ${it.detalle}",
                        descrip = "Sin profesor asignado",
                        click = {
                            toVerSalon(it.id)
                        },
                        onlongClick = {
                            alertEliminar(context, "${it.grado}${it.detalle}") {
                                viewModel.delete(it)
                            }
                        }
                    )
                }
            }
            if (list.size < 26) {
                FloatingActionButton(
                    onClick = {
                        viewModel.insertarSeccion(grado)
                    },
                    containerColor = ColorS1,
                    contentColor = Color.White,
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Icon(imageVector = Icons.Default.School, contentDescription = null)
                }
            }
        }
    }
}

