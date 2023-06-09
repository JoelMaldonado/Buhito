package com.jjmf.elementaryschool.ui.features.Director.VerGrados

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.elementaryschool.model.Seccion
import com.jjmf.elementaryschool.ui.components.CajaBuscar
import com.jjmf.elementaryschool.ui.components.ItemMaestro
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.util.Recursos

@Composable
fun VerGradosScreen(
    back: () -> Unit,
    toVerSecciones: (Int) -> Unit,
    viewModel: VerGradosViewModel = hiltViewModel(),
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit){
        viewModel.getSeccion()
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
                descrip = getCant(viewModel.list.filter { it.grado == 1 }),
                click = {
                    toVerSecciones(1)
                },
                onlongClick = {}
            )
            ItemMaestro(
                img = Recursos.getBuhito(),
                init = "2°",
                titulo = "Grado",
                descrip = getCant(viewModel.list.filter { it.grado == 2 }),
                click = {
                    toVerSecciones(2)
                },
                onlongClick = {}
            )
            ItemMaestro(
                img = Recursos.getBuhito(),
                init = "3°",
                titulo = "Grado",
                descrip = getCant(viewModel.list.filter { it.grado == 3 }),
                click = {
                    toVerSecciones(3)
                },
                onlongClick = {}
            )
            ItemMaestro(
                img = Recursos.getBuhito(),
                init = "4°",
                titulo = "Grado",
                descrip = getCant(viewModel.list.filter { it.grado == 4 }),
                click = {
                    toVerSecciones(4)
                },
                onlongClick = {}
            )
            ItemMaestro(
                img = Recursos.getBuhito(),
                init = "5°",
                titulo = "Grado",
                descrip = getCant(viewModel.list.filter { it.grado == 5 }),
                click = {
                    toVerSecciones(5)
                },
                onlongClick = {}
            )
            ItemMaestro(
                img = Recursos.getBuhito(),
                init = "6°",
                titulo = "Grado",
                descrip = getCant(viewModel.list.filter { it.grado == 6 }),
                click = {
                    toVerSecciones(6)
                },
                onlongClick = {}
            )
        }

    }

}

private fun getCant(list: List<Seccion>) :String{
    return try {
        if (list.isNotEmpty()){
            "${list.size} Secciones"
        }else "Sin secciones"
    }catch (e:Exception){
        "Sin secciones"
    }
}