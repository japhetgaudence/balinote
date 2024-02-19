package com.balitech.balinote.core_ui.components.appbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.balitech.balinote.R
import com.balitech.balinote.core_ui.components.icons.ActionIcon
import com.balitech.balinote.core_ui.theme.dimensions.elevation
import com.balitech.balinote.core_ui.theme.dimensions.spacing

@Composable
fun SearchBar(
    onClick: () -> Unit,
    onToggleLayout: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface.copy(0.85f),
    shape: Shape = RoundedCornerShape(50),
    tonalElevation: Dp = MaterialTheme.elevation.medium,
    iconSize: Dp = 20.dp
) {
    Surface(
        onClick = onClick,
        color = containerColor,
        tonalElevation = tonalElevation,
        shape = shape,
        modifier = modifier.padding(MaterialTheme.spacing.medium)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.thin
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.label_search),
                    tint = contentColor,
                    modifier = Modifier.size(iconSize)
                )
                Text(
                    text = stringResource(id = R.string.label_search),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    color = contentColor
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                ActionIcon(
                    onClick = onToggleLayout,
                    icon = Icons.Outlined.Notifications,
                    size = iconSize
                )
                ActionIcon(
                    onClick = onToggleLayout,
                    icon = Icons.Outlined.MoreVert,
                    size = iconSize
                )
            }
        }
    }
}