package com.balitech.balinote.core_ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material.icons.outlined.NoteAlt
import androidx.compose.material.icons.outlined.TaskAlt
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.ui.graphics.vector.ImageVector
import com.balitech.balinote.R
import com.balitech.balinote.presentation.destinations.NoteDetailsScreenDestination
import com.balitech.balinote.presentation.destinations.ProjectDetailsScreenDestination
import com.balitech.balinote.presentation.destinations.TaskDetailsScreenDestination
import com.balitech.balinote.presentation.destinations.WorkspaceDetailsScreenDestination
import com.ramcosta.composedestinations.spec.Direction

sealed class CreateResourceItem(
    val direction: Direction,
    @StringRes val label: Int,
    val icon: ImageVector
) {
    data object Note: CreateResourceItem(
        direction = NoteDetailsScreenDestination,
        label = R.string.label_note,
        icon = Icons.Outlined.NoteAlt
    )

    data object Task: CreateResourceItem(
        direction = TaskDetailsScreenDestination,
        label = R.string.label_task,
        icon = Icons.Outlined.TaskAlt
    )

    data object Project: CreateResourceItem(
        direction = ProjectDetailsScreenDestination,
        label = R.string.label_project,
        icon = Icons.Outlined.WorkOutline
    )

    data object Workspace: CreateResourceItem(
        direction = WorkspaceDetailsScreenDestination,
        label = R.string.label_workspace,
        icon = Icons.Outlined.Folder
    )


    companion object {
        fun values(): List<CreateResourceItem> = listOf(
            Note,
            Task,
            Project,
            Workspace
        )
    }
}