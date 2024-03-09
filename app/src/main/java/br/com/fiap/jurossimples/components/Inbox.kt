package br.com.fiap.jurossimples.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun Inbox(
    value: String,
    placeHolder: String,
    label: String,
    keyBoardType: KeyboardType,
    modifier: Modifier,
    uptadeValue: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = uptadeValue,
        modifier = modifier,
        label = { Text(text = label) },
        placeholder = { Text(text = placeHolder) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType
        )
    )
}