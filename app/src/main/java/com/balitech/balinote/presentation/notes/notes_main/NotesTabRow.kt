package com.balitech.balinote.presentation.notes.notes_main

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight


@Composable
fun NotesTabRow(
    selectedTabIndex: Int,
    onTabClick: (index: Int) -> Unit,
    modifier: Modifier = Modifier,
    tabs: List<NotesTab> = NotesTab.values(),
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    selectedTabColor: Color = MaterialTheme.colorScheme.primary,
    unselectedTabColor: Color = MaterialTheme.colorScheme.onBackground.copy(0.85f),
    divider: @Composable () -> Unit = {}
) {

    TabRow(
        selectedTabIndex = selectedTabIndex,
        tabs = {
            tabs.forEachIndexed { index, tab ->
                val selected = selectedTabIndex == index

                Tab(
                    selected = selected,
                    selectedContentColor = selectedTabColor,
                    unselectedContentColor = unselectedTabColor,
                    onClick = { if (!selected) onTabClick(index) },
                    text = {
                        Text(
                            text = stringResource(id = tab.label),
                            style = textStyle,
                            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Medium
                        )
                    }
                )
            }
        },
        divider = divider,
        modifier = modifier
    )
}
