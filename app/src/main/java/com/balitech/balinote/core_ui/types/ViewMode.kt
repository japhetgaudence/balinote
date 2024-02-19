package com.balitech.balinote.core_ui.types

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.ViewAgenda
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ViewMode(
    val icon: ImageVector,
    val columnsCount: Int
) {
    data object List: ViewMode(
        icon = Icons.Outlined.GridView,
        columnsCount = 1
    )

    data object Grid: ViewMode(
        icon = Icons.Outlined.ViewAgenda,
        columnsCount = 2
    )

    companion object {
        fun toggle(currentView: ViewMode): ViewMode = when(currentView) {
            Grid -> List
            List -> Grid
        }
    }
}