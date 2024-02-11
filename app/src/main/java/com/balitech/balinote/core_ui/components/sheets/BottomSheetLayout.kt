package com.balitech.balinote.core_ui.components.sheets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import com.balitech.balinote.core_ui.components.icons.ActionIcon
import com.balitech.balinote.core_ui.theme.dimensions.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetLayout(
    sheetState: SheetState,
    sheetTitle: String,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    onDismiss: (() -> Unit)? = null,
    dismissIcon: ImageVector? = null,
    shape: Shape = MaterialTheme.shapes.large,
    titleStyle: TextStyle = MaterialTheme.typography.headlineSmall,
    titleColor: Color = MaterialTheme.colorScheme.onSurface,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismissRequest,
        shape = shape,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.large)
        ) {
            Text(
                text = sheetTitle,
                style = titleStyle,
                color = titleColor
            )

            if (dismissIcon != null && onDismiss != null) {
                ActionIcon(icon = dismissIcon, onClick = onDismiss)
            }
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

        content(this)

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
    }
}