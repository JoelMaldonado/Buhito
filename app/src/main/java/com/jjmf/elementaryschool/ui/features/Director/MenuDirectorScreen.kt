package com.jjmf.elementaryschool.ui.features.Director

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.elementaryschool.R
import com.jjmf.elementaryschool.ui.components.CardMenu
import com.jjmf.elementaryschool.ui.theme.ColorP1
import com.jjmf.elementaryschool.ui.theme.ColorS1

@Composable
fun MenuDirectorScreen(
    toProfesor: () -> Unit,
    toCurso: () -> Unit,
    toGrado: () -> Unit,
    viewModel: MenuDirectorViewModel = hiltViewModel(),
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
                    .size(120.dp),
                tint = ColorS1
            )

            CardMenu(
                img = "",
                texto = "Profesores",
                click = toProfesor
            )

            CardMenu(
                img = "",
                texto = "Cursos",
                click = toCurso
            )

            CardMenu(
                img = "",
                texto = "Grados",
                click = toGrado
            )

        }
    }
}