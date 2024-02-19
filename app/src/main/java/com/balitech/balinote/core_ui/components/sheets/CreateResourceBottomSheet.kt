package com.balitech.balinote.core_ui.components.sheets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.balitech.balinote.core_ui.components.icons.TonalIcon
import com.balitech.balinote.core_ui.types.CreateResourceItem
import com.balitech.balinote.core_ui.theme.dimensions.elevation
import com.balitech.balinote.core_ui.theme.dimensions.spacing
import com.ramcosta.composedestinations.spec.Direction



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateResourceBottomSheet(
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    onNavigate: (Direction) -> Unit,
) {
    BottomSheetLayout(
        sheetState = sheetState,
        sheetTitle = "Create",
        onDismissRequest = onDismissRequest,
    ) {
        LazyColumn(
            state = rememberLazyListState(),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.default),
            contentPadding = PaddingValues(vertical = MaterialTheme.spacing.large),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items = CreateResourceItem.values()) { item ->
                CreateResourceBottomSheetItem(
                    item = item,
                    onClick = onNavigate
                )
            }
        }
    }
}


@Composable
private fun CreateResourceBottomSheetItem(
    item: CreateResourceItem,
    onClick: (Direction) -> Unit,
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.background,
    shape: Shape = MaterialTheme.shapes.medium,
    tonalElevation: Dp = MaterialTheme.elevation.default,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    itemsSpacing: Dp = MaterialTheme.spacing.large,
    contentPadding: Dp = MaterialTheme.spacing.medium
) {
    Surface(
        onClick = { onClick(item.direction) },
        shape = shape,
        color = background,
        tonalElevation = tonalElevation,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(itemsSpacing),
            modifier = Modifier.fillMaxWidth().padding(contentPadding)
        ) {
            TonalIcon(
                icon = item.icon
            )

            Text(
                text = stringResource(id = item.label),
                style = textStyle,
                color = textColor,
                fontWeight = FontWeight.Medium
            )
        }
    }
}