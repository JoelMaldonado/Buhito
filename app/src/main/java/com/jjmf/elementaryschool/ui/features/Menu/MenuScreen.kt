package com.jjmf.elementaryschool.ui.features.Menu

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jjmf.elementaryschool.R
import com.jjmf.elementaryschool.ui.theme.ColorP1
import com.jjmf.elementaryschool.ui.theme.ColorS1
import com.jjmf.elementaryschool.util.Recursos

@Composable
fun MenuScreen(
    toUsuario: () -> Unit,
    toCurso: () -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorP1)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_atomo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_buho),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp),
                tint = ColorS1
            )
            Text(
                text = "Bienvenido Joel,\n\nSeleccione una de las siguientes opciones:",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 20.dp)
            )

            CardMenu(
                img = Recursos.getAlumno(),
                texto = "Usuarios",
                click = toUsuario
            )
            CardMenu(
                img = Recursos.getCurso(),
                texto = "Cursos",
                click = toCurso
            )

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CardMenu(
    @DrawableRes img: Int,
    texto: String,
    click: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(20.dp),
        onClick = click,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = texto, fontSize = 30.sp, fontWeight = FontWeight.Bold)

            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
        }

    }
}