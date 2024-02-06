package com.balitech.balinote.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.PermMedia
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material.icons.filled.Workspaces
import androidx.compose.material.icons.outlined.NoteAlt
import androidx.compose.material.icons.outlined.PermMedia
import androidx.compose.material.icons.outlined.TaskAlt
import androidx.compose.material.icons.outlined.Workspaces
import androidx.compose.ui.graphics.vector.ImageVector
import com.balitech.balinote.R
import com.balitech.balinote.presentation.library.library_main.LIBRARY_MAIN_SCREEN_ROUTE
import com.balitech.balinote.presentation.notes.notes_main.NOTES_MAIN_SCREEN_ROUTE
import com.balitech.balinote.presentation.tasks.tasks_main.TASKS_MAIN_SCREEN_ROUTE
import com.balitech.balinote.presentation.workspaces.workspaces_main.WORKSPACES_MAIN_SCREEN_ROUTE

sealed class BottomNavItem(
    val route: String,
    @StringRes val label: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {

    data object Tasks: BottomNavItem(
        route = TASKS_MAIN_SCREEN_ROUTE,
        label = R.string.label_tasks,
        selectedIcon = Icons.Filled.TaskAlt,
        unselectedIcon = Icons.Outlined.TaskAlt
    )

    data object Notes: BottomNavItem(
        route = NOTES_MAIN_SCREEN_ROUTE,
        label = R.string.label_notes,
        selectedIcon = Icons.Filled.NoteAlt,
        unselectedIcon = Icons.Outlined.NoteAlt
    )
    data object Add: BottomNavItem(
        route = "/add",
        label = R.string.label_add,
        selectedIcon = Icons.Filled.AddCircle,
        unselectedIcon = Icons.Filled.AddCircle
    )

    data object Workspaces: BottomNavItem(
        route = WORKSPACES_MAIN_SCREEN_ROUTE,
        label = R.string.label_workspaces,
        selectedIcon = Icons.Filled.Workspaces,
        unselectedIcon = Icons.Outlined.Workspaces
    )

    data object Library: BottomNavItem(
        route = LIBRARY_MAIN_SCREEN_ROUTE,
        label = R.string.label_library,
        selectedIcon = Icons.Filled.PermMedia,
        unselectedIcon = Icons.Outlined.PermMedia
    )


    companion object {
        fun getItems(): Set<BottomNavItem> = setOf(
            Tasks,
            Notes,
            Add,
            Workspaces,
            Library
        )

        fun getItem(route: String?): BottomNavItem {
            return when(route) {
                Tasks.route -> Tasks
                Notes.route -> Notes
                Add.route -> Add
                Workspaces.route -> Workspaces
                Library.route -> Library
                else -> Tasks
            }
        }
    }
}