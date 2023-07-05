package com.jjmf.elementaryschool.ui.features.Director.VerCursos

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdd
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
import com.jjmf.elementaryschool.ui.components.ItemMaestro
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.features.Director.VerProfesores.alertEliminar
import com.jjmf.elementaryschool.ui.theme.ColorP1

@Composable
fun CursoMaestroScreen(
    back: () -> Unit,
    toAgregarCurso: () -> Unit,
    viewModel: VerCursosViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    LaunchedEffect(key1 = Unit){
        viewModel.getCursos()
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Top(
            back = back,
            titulo = "Cursos"
        )

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
                    Spacer(modifier = Modifier.height(10.dp))
                }
                items(viewModel.listCursos){
                    ItemMaestro(
                        img = it.img,
                        titulo = it.detalle,
                        descrip = "20/04/2023",
                        click = {},
                        onlongClick = {
                            alertEliminar(context = context, it.detalle){
                                viewModel.deleteCurso(it)
                            }
                        }
                    )
                }
            }
            FloatingActionButton(
                onClick = toAgregarCurso,
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = Color.White,
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Icon(imageVector = Icons.Default.BookmarkAdd, contentDescription = null)
            }

        }
    }
}