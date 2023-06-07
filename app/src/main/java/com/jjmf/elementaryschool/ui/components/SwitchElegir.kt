package com.jjmf.elementaryschool.ui.features.Director.AgregarEditarProfesor.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun SwitchElegir(
    @DrawableRes opcion1:Int,
    color1: Color,
    @DrawableRes opcion2:Int,
    color2: Color,
    bool:Boolean,
    newBool:(Boolean)->Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            modifier = Modifier.size(50.dp),
            painter = painterResource(id = opcion1),
            contentDescription = null,
            tint = color1
        )
        Switch(
            checked = bool,
            onCheckedChange = newBool,
            colors = SwitchDefaults.colors(
                uncheckedTrackColor = color1.copy(0.5f),
                uncheckedThumbColor = color1,
                checkedTrackColor = color2.copy(0.5f),
                checkedThumbColor = color2,
                uncheckedBorderColor = Color.Transparent,
                checkedBorderColor = Color.Transparent
            )
        )
        Icon(
            modifier = Modifier.size(50.dp),
            painter = painterResource(id = opcion2),
            contentDescription = null,
            tint = color2
        )

    }
}
