package com.jjmf.elementaryschool.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CajaTexto(
    valor: String,
    newValor: (String) -> Unit,
    label: String,
    placeholder: String = "",
    trailingIcon: @Composable (() -> Unit)? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier,
    visual: VisualTransformation = VisualTransformation.None,
    imeAction: ImeAction = ImeAction.Default,
    keyboardType:KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    enable:Boolean = true
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
        placeholder = {
            Text(text = placeholder)
        },
        trailingIcon = trailingIcon,
        visualTransformation = visual,
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = keyboardType,
            capitalization = KeyboardCapitalization.Words
        ),
        keyboardActions = keyboardActions,
        enabled = enable
    )
}