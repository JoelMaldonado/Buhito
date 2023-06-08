package com.jjmf.elementaryschool.ui.features.Director.VerGrados

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdd
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.elementaryschool.model.Usuario
import com.jjmf.elementaryschool.ui.components.CajaBuscar
import com.jjmf.elementaryschool.ui.components.ItemMaestro
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.features.Director.VerProfesores.alertEliminar
import com.jjmf.elementaryschool.ui.theme.ColorP1
import com.jjmf.elementaryschool.util.Recursos

@Composable
fun VerGradosScreen(
    back: () -> Unit,
    toAddEditGrado: () -> Unit,
    toVerSecciones:()->Unit,
    viewModel: VerGradosViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    LaunchedEffect(key1 = Unit){
        viewModel.getGrados()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Top(
            back = back,
            titulo = "Grados"
        )


        CajaBuscar(
            valor = viewModel.filtro,
            newValor = { valor ->
                viewModel.filtro = valor
                viewModel.listGrado =
                    viewModel.listGradoMain.filter {
                        it.detalle.uppercase().contains(valor.uppercase())
                    }
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {


            ItemMaestro(
                img = Recursos.getBuhito(),
                init = "1°",
                titulo = "Grado",
                descrip = "3 Secciones",
                click = toVerSecciones,
                onlongClick = {}
            )
            ItemMaestro(
                img = Recursos.getBuhito(),
                init = "2°",
                titulo = "Grado",
                descrip = "3 Secciones",
                click = {},
                onlongClick = {}
            )
            ItemMaestro(
                img = Recursos.getBuhito(),
                init = "3°",
                titulo = "Grado",
                descrip = "3 Secciones",
                click = {},
                onlongClick = {}
            )
            ItemMaestro(
                img = Recursos.getBuhito(),
                init = "4°",
                titulo = "Grado",
                descrip = "3 Secciones",
                click = {},
                onlongClick = {}
            )
            ItemMaestro(
                img = Recursos.getBuhito(),
                init = "5°",
                titulo = "Grado",
                descrip = "3 Secciones",
                click = {},
                onlongClick = {}
            )
            ItemMaestro(
                img = Recursos.getBuhito(),
                init = "6°",
                titulo = "Grado",
                descrip = "3 Secciones",
                click = {},
                onlongClick = {}
            )
        }

        /*

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(ColorP1)
                .clip(RoundedCornerShape(topEnd = 30.dp))
                .background(Color.White)
                .padding(horizontal = 15.dp),
            contentAlignment = Alignment.BottomEnd
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                item {
                    CajaBuscar(
                        valor = viewModel.filtro,
                        newValor = { valor ->
                            viewModel.filtro = valor
                            viewModel.listGrado =
                                viewModel.listGradoMain.filter {
                                    it.detalle.uppercase().contains(valor.uppercase())
                                }
                        }
                    )
                }

                items(viewModel.listGrado){

                    val primero = it.detalle[0].uppercase()
                    val segundo = if (it.seccion.isNotEmpty()) it.seccion.first().uppercase() else ""

                    ItemMaestro(
                        img = Recursos.getBuhito(),
                        init = primero + segundo,
                        titulo = "Sin Asignar Profesor",
                        descrip = "Se creo el 01/01/2023",
                        click = {},
                        onlongClick = {
                            alertEliminar(context = context, it.detalle){
                                viewModel.deleteGrado(it)
                            }
                        }
                    )
                }
            }

            FloatingActionButton(
                onClick = toAddEditGrado,
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = Color.White,
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Icon(imageVector = Icons.Default.School, contentDescription = null)
            }

        }

        */

    }

}