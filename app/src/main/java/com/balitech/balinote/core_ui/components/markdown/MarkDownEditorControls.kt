package com.balitech.balinote.core_ui.components.markdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatBold
import androidx.compose.material.icons.filled.FormatItalic
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.balitech.balinote.core_ui.components.icons.ActionIcon
import com.balitech.balinote.core_ui.theme.dimensions.elevation
import com.balitech.balinote.core_ui.theme.dimensions.spacing

@Composable
fun MarkDownEditorControls(
    setBold: () -> Unit,
    setItalic: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.large,
    tonalElevation: Dp = MaterialTheme.elevation.medium,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    itemsSpacing: Dp = MaterialTheme.spacing.default,
    boldIcon: ImageVector = Icons.Default.FormatBold,
    italicIcon: ImageVector = Icons.Default.FormatItalic,
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = backgroundColor,
        tonalElevation = tonalElevation
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(itemsSpacing),
            modifier = Modifier.fillMaxWidth()
        ) {
            ActionIcon(
                icon = boldIcon,
                onClick = setBold
            )
            ActionIcon(
                icon = italicIcon,
                onClick = setItalic
            )
        }
    }
}