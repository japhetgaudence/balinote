package com.balitech.balinote.core_ui.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.balitech.balinote.core_ui.theme.dimensions.spacing

@Composable
fun TagCard(
    tag: String,
    modifier: Modifier = Modifier,
    background: Color = Color.Transparent,
    shape: Shape = RoundedCornerShape(50),
    borderWidth: Dp = Dp.Hairline,
    borderColor: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.labelSmall,
    horizontalPadding: Dp = MaterialTheme.spacing.small,
    verticalPadding: Dp = MaterialTheme.spacing.small
) {
    Surface(
        color = background,
        shape = shape,
        border = BorderStroke(width = borderWidth, color = borderColor),
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(
                horizontal = horizontalPadding,
                vertical = verticalPadding
            )
        ) {
            Text(
                text = tag,
                style = style
            )
        }
    }
}