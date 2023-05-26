package com.jjmf.elementaryschool.ui.features.Director.AgregarUsuario

import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jjmf.elementaryschool.R
import com.jjmf.elementaryschool.ui.components.CajaTexto
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.features.Director.AgregarUsuario.components.SwitchElegir
import com.jjmf.elementaryschool.ui.theme.ColorAlumno
import com.jjmf.elementaryschool.ui.theme.ColorHembra
import com.jjmf.elementaryschool.ui.theme.ColorMacho
import com.jjmf.elementaryschool.ui.theme.ColorP1
import com.jjmf.elementaryschool.ui.theme.ColorProfesor
import com.jjmf.elementaryschool.ui.theme.ColorS1
import com.jjmf.elementaryschool.util.Recursos

@Composable
fun AgregarUsuarioScreen(
    back: () -> Unit,
    viewModel: AgregarUsuarioViewModel = hiltViewModel(),
) {

    val focus = LocalFocusManager.current

    LaunchedEffect(key1 = Unit){
        viewModel.iconoUsuarioMain = Recursos.getMaestro()
    }

    if (viewModel.back){
        LaunchedEffect(key1 = Unit){
            back()
        }
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Top(
            back = back,
            titulo = "Añadir Usuario"
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(ColorP1)
                .clip(RoundedCornerShape(topEnd = 30.dp))
                .background(Color.White)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                CajaTexto(
                    modifier = Modifier.weight(1f),
                    valor = viewModel.correo,
                    newValor = {
                        viewModel.correo = it
                    },
                    label = "Correo electronico",
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focus.moveFocus(FocusDirection.Down)
                        }
                    )
                )

                AsyncImage(
                    model = viewModel.iconoUsuarioMain,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
            }

            CajaTexto(
                modifier = Modifier.fillMaxWidth(),
                valor = viewModel.nombre,
                newValor = {
                    viewModel.nombre = it
                },
                label = "Nombres",
                imeAction = ImeAction.Next,
                keyboardActions = KeyboardActions(
                    onNext = {
                        focus.moveFocus(FocusDirection.Down)
                    }
                )
            )
            CajaTexto(
                valor = viewModel.apellido,
                newValor = {
                    viewModel.apellido = it
                },
                label = "Apellidos",
                imeAction = ImeAction.Next,
                keyboardActions = KeyboardActions(
                    onNext = {
                        focus.moveFocus(FocusDirection.Down)
                    }
                )
            )
            CajaTexto(
                valor = viewModel.celular,
                newValor = {
                    viewModel.celular = it
                },
                label = "Celular",
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Done,
                keyboardActions = KeyboardActions(
                    onDone = {
                        focus.clearFocus()
                    }
                )
            )
            SwitchElegir(
                opcion1 = R.drawable.ic_profesor,
                color1 = ColorProfesor,
                opcion2 = R.drawable.ic_alumno,
                color2 = ColorAlumno,
                bool = viewModel.tipo,
                newBool = {
                    viewModel.tipo = it
                    viewModel.validarIcono()
                }
            )
            SwitchElegir(
                opcion1 = R.drawable.ic_hombre,
                color1 = ColorMacho,
                opcion2 = R.drawable.ic_mujer,
                color2 = ColorHembra,
                bool = viewModel.genero,
                newBool = {
                    viewModel.genero = it
                    viewModel.validarIcono()
                }
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = viewModel::insertarUsuario,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorS1
                ),
                enabled = Patterns.EMAIL_ADDRESS.matcher(viewModel.correo).matches()
            ) {
                Text(text = "Guardar", fontSize = 18.sp)
            }
        }
    }

}