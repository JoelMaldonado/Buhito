package com.jjmf.elementaryschool.ui.features.Login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.elementaryschool.R
import com.jjmf.elementaryschool.ui.theme.ColorP1
import com.jjmf.elementaryschool.ui.theme.ColorS1

@Composable
fun LoginScreen(
    toMenuDirector: (String) -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),
) {

    val context = LocalContext.current

    viewModel.error?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        viewModel.error = null
    }
    viewModel.toMenu?.let {
        LaunchedEffect(key1 = Unit) {
            toMenuDirector(it)
            viewModel.toMenu = null
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorP1)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .clip(RoundedCornerShape(bottomStart = 50.dp))
                .background(ColorP1)
                .weight(1f)
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_atomo),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_buho),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clickable {
                                   viewModel.insertarUsuarioTest()
                        },
                    tint = ColorS1
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Buhito",
                    color = ColorS1,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 26.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Log In",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 30.sp
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(topEnd = 50.dp))
                .background(Color.White)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            CajaLogin(
                titulo = "Correo",
                label = "correo@example.com",
                valor = viewModel.correo,
                newValor = {
                    viewModel.correo = it
                }
            )
            Column {
                CajaLogin(
                    titulo = "Contraseña",
                    label = "**********",
                    valor = viewModel.clave,
                    newValor = {
                        viewModel.clave = it
                    }
                )
                Recuerdame()
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = viewModel::signIn,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorS1
                )
            ) {
                Text(text = "Ingresar", fontSize = 18.sp)
            }

            Text(
                text = "¿Olvidaste tu contraseña?",
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable { },
                color = ColorS1
            )
        }
    }
}

@Composable
fun Recuerdame() {
    val bool = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = bool.value,
            onCheckedChange = {
                bool.value = it
            }
        )
        Text(text = "Recuerdame", fontSize = 14.sp)
    }
}

@Composable
fun CajaLogin(
    titulo: String,
    label: String,
    valor: String,
    newValor: (String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = titulo,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            if (valor.isEmpty()) {
                Text(
                    text = label,
                    fontSize = 20.sp,
                    color = Color.Gray.copy(0.5f)
                )
            }
            BasicTextField(
                value = valor,
                onValueChange = newValor,
                textStyle = TextStyle(fontSize = 18.sp),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}