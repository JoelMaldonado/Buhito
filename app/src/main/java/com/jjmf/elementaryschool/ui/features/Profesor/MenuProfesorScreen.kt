package com.jjmf.elementaryschool.ui.features.Profesor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Note
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.theme.ColorP1
import com.jjmf.elementaryschool.ui.theme.ColorS1
import com.jjmf.elementaryschool.ui.theme.ColorS2

@Composable
fun MenuProfesorScreen(
    toCursos: () -> Unit,
    back: () -> Unit,
    viewModel: MenuProfesorViewModel = hiltViewModel(),
) {

    val user = viewModel.user.collectAsState().value
    val list = viewModel.list.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Top(
            back = back,
            titulo = "Salon 1A"
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
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                CardMenuProfesor(
                    modifier = Modifier.weight(1f),
                    text = "Ver Alumnos",
                    icon = Icons.Default.Group,
                    click = {

                    }
                )
                CardMenuProfesor(
                    modifier = Modifier.weight(1f),
                    text = "Notas",
                    icon = Icons.Default.Note,
                    click = {

                    }
                )
            }

            CardMenuProfesor(
                modifier = Modifier.fillMaxWidth(),
                text = "Cursos",
                icon = Icons.Default.Book,
                click = toCursos
            )

            if (user != null) {
                Text(text = user.toString())
            }

            LazyColumn{
                items(list){

                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardMenuProfesor(
    modifier: Modifier,
    text: String,
    icon: ImageVector,
    click: () -> Unit,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        onClick = click
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(ColorS1.copy(0.7f)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomEnd = 100.dp, bottomStart = 100.dp))
                    .background(ColorS1)
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(35.dp)
                )
            }

            Text(
                text = text,
                color = Color.White,
                modifier = Modifier.padding(vertical = 15.dp)
            )
        }
    }
}
