package com.jjmf.elementaryschool.ui.features.Director.AgregarCurso

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jjmf.elementaryschool.ui.components.CajaTexto
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.features.Director.components.AlertSeleccionarIconoCurso
import com.jjmf.elementaryschool.ui.features.Director.components.CardProfesor
import com.jjmf.elementaryschool.ui.theme.ColorP1
import com.jjmf.elementaryschool.ui.theme.ColorS1
import com.jjmf.elementaryschool.util.Recursos

@Composable
fun AgregarCursoScreen(
    back: () -> Unit,
    viewModel: AgregarCursoViewModel = hiltViewModel(),
) {

    val focus = LocalFocusManager.current

    LaunchedEffect(key1 = Unit){
        viewModel.getProfesores()
    }

    if (viewModel.alertSeleccionarIcono) {
        AlertSeleccionarIconoCurso(
            close = {
                viewModel.alertSeleccionarIcono = false
            },
            click = {
                viewModel.iconoCursoMain = it
                viewModel.alertSeleccionarIcono = false
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Top(
            back = back,
            titulo = "Añadir Curso"
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
                    valor = viewModel.nombreCurso,
                    newValor = {
                        viewModel.nombreCurso = it
                    },
                    label = "Nombre del curso",
                    imeAction = ImeAction.Next,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focus.moveFocus(FocusDirection.Down)
                        }
                    )
                )

                AsyncImage(
                    model = viewModel.iconoCursoMain,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .clickable {
                            viewModel.alertSeleccionarIcono = true
                        }
                )
            }

            Text(
                text = "Selecciona un profesor",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(viewModel.listProfesores) {
                    CardProfesor(
                        foto = it.icono,
                        nombre = it.nombre,
                        descrip = "Se unio el 26/05/2023",
                        click = {

                        }
                    )
                }
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorS1
                )
            ) {
                Text(text = "Guardar", fontSize = 18.sp)
            }
        }
    }

}