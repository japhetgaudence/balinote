package com.balitech.balinote.core_ui.components.icons

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.balitech.balinote.core_ui.theme.dimensions.elevation

@Composable
fun TonalIcon(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    description: String? = null,
    shape: Shape = CircleShape,
    background: Color = MaterialTheme.colorScheme.surface,
    tonalElevation: Dp = MaterialTheme.elevation.large,
    contentPadding: Dp = MaterialTheme.elevation.large,
) {
    Surface(
        onClick = onClick,
        shape = shape,
        color = background,
        tonalElevation = tonalElevation,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            modifier = Modifier.padding(contentPadding)
        )
    }
}