package com.jjmf.elementaryschool.ui.features.Director.UsuarioMaestro

import android.content.Context
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.PersonAdd
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
import cn.pedant.SweetAlert.SweetAlertDialog
import com.jjmf.elementaryschool.ui.components.CajaBuscar
import com.jjmf.elementaryschool.ui.components.ItemMaestro
import com.jjmf.elementaryschool.ui.components.Top
import com.jjmf.elementaryschool.ui.theme.ColorP1
import com.jjmf.elementaryschool.ui.theme.ColorS1

@Composable
fun UsuarioMaestroScreen(
    back: () -> Unit,
    toAgregarUsuario: () -> Unit,
    viewModel: UsuarioMaestroViewModel = hiltViewModel(),
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getList()
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Top(
            back = back,
            titulo = "Usuarios"
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
            ) {
                item {
                    CajaBuscar(
                        valor = viewModel.filtro,
                        newValor = { valor ->
                            viewModel.filtro = valor
                            viewModel.listUsuarios =
                                viewModel.listUsuariosMain.filter {
                                    it.nombre.uppercase().contains(valor.uppercase())
                                }
                        }
                    )
                }
                items(viewModel.listUsuarios) {
                    ItemMaestro(
                        img = it.icono,
                        titulo = it.nombre,
                        descrip = if (it.tipoUsuario == "A") "Alumno" else "Profesor",
                        click = {

                        },
                        onlongClick = {
                            alertEliminar(
                                context = context,
                                nombre = it.nombre,
                                click = {
                                    viewModel.delete(it)
                                }
                            )
                        }
                    )
                }
            }
            FloatingActionButton(
                onClick = toAgregarUsuario,
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = Color.White,
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Icon(imageVector = Icons.Default.PersonAdd, contentDescription = null)
            }
        }
    }

}

fun alertEliminar(context: Context, nombre: String, click: () -> Unit) {
    SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE).apply {
        titleText = "Cuidado"
        contentText = "Estas seguro de eliminar este usuario '${nombre.uppercase()}'"
        confirmButtonBackgroundColor = ColorP1.hashCode()
        setConfirmButton("Confirmar") {
            click()
            dismissWithAnimation()
        }
        cancelButtonBackgroundColor = ColorS1.hashCode()
        setCancelButton("Cancelar") {
            dismissWithAnimation()
        }
        show()
    }
}
