package com.balitech.balinote.core_ui.components.markdown

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import com.balitech.balinote.R


@Composable
fun MarkDownEditor(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = stringResource(id = R.string.hint_tap_here_to_edit_note),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    hintColor: Color = textColor.copy(alpha = 0.65f)
) {
    var isFocused: Boolean by rememberSaveable { mutableStateOf(false) }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle.copy(color = textColor),
        cursorBrush = Brush.verticalGradient(listOf(textColor, textColor)),
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
        decorationBox = { newText ->
            Box(modifier = modifier) {
                if (value.text.isEmpty() && !isFocused) {
                    Text(
                        text = hint,
                        style = textStyle.copy(color = hintColor)
                    )
                }

                newText()
            }
        },
        modifier = modifier.onFocusChanged { focusState: FocusState ->
            isFocused = focusState.isFocused
        }

    )
}

