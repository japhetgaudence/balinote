package com.balitech.balinote.presentation.notes.note_details

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.PushPin
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.balitech.balinote.core_ui.components.icons.ActionIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailsScreenTopBar(
    onNavigateUp: () -> Unit,
    onPinNote: () -> Unit,
    onArchiveNote: () -> Unit,
    onContextMenuClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    navigationIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    pinIcon: ImageVector = Icons.Outlined.PushPin,
    archiveIcon: ImageVector = Icons.Outlined.Archive,
    contextMenuIcon: ImageVector = Icons.Outlined.MoreVert,
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(state = topAppBarState)

    TopAppBar(
        title = {},
        navigationIcon = {
            ActionIcon(icon = navigationIcon, onClick = onNavigateUp)
        },
        actions = {
            ActionIcon(icon = pinIcon, onClick = onPinNote)
            ActionIcon(icon = archiveIcon, onClick = onArchiveNote)
            ActionIcon(icon = contextMenuIcon, onClick = onContextMenuClick)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
            scrolledContainerColor = backgroundColor
        ),
        scrollBehavior = scrollBehavior,
        modifier = modifier.fillMaxWidth()
    )
}