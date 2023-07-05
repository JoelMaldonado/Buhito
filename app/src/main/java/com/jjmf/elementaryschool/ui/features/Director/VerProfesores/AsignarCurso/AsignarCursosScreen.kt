package com.jjmf.elementaryschool.ui.features.Director.VerProfesores.AsignarCurso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.features.Director.components.CardProfesor
import com.jjmf.elementaryschool.ui.theme.ColorP1

@Composable
fun AsignarCursosScreen(
    id: Int? = null,
    back: () -> Unit,
    viewModel: AsignarCursosViewModel = hiltViewModel()
) {

    val listCursos = viewModel.listCursos.collectAsState().value


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Top(
            back = back,
            titulo = "Asignar Curso"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(ColorP1)
                .clip(RoundedCornerShape(topEnd = 30.dp))
                .background(Color.White)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ){
                if (listCursos.isEmpty()){
                    item {
                        Text(text = "Sin cursos", modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp), textAlign = TextAlign.Center)
                    }
                }else{

                    items(listCursos){
                        CardProfesor(foto = it.img, nombre = it.detalle, descrip = "Creado el 07/06/2023") {

                        }
                    }
                }
            }
        }
    }
}