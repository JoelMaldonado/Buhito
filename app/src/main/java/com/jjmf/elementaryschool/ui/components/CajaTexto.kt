package com.jjmf.elementaryschool.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CajaTexto(
    valor: String,
    newValor: (String) -> Unit,
    label: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier,
    visual: VisualTransformation = VisualTransformation.None,
) {
    TextField(
        value = valor,
        onValueChange = newValor,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedLabelColor = color,
            focusedIndicatorColor = color,
            cursorColor = color
        ),
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(text = label)
        },
        trailingIcon = trailingIcon,
        visualTransformation = visual
    )
}