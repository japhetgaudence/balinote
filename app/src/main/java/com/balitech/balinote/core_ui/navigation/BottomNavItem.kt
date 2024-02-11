package com.balitech.balinote.core_ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material.icons.outlined.NoteAlt
import androidx.compose.material.icons.outlined.TaskAlt
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.ui.graphics.vector.ImageVector
import com.balitech.balinote.R
import com.balitech.balinote.presentation.destinations.NotesMainScreenDestination
import com.balitech.balinote.presentation.destinations.ProjectsMainScreenDestination
import com.balitech.balinote.presentation.destinations.TasksMainScreenDestination
import com.balitech.balinote.presentation.destinations.WorkspacesMainScreenDestination
import com.ramcosta.composedestinations.spec.Direction

sealed class BottomNavItem(
    val destination: Direction?,
    @StringRes val label: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {

    data object Notes: BottomNavItem(
        destination = NotesMainScreenDestination,
        label = R.string.destination_notes,
        selectedIcon = Icons.Filled.NoteAlt,
        unselectedIcon = Icons.Outlined.NoteAlt
    )

    data object Tasks: BottomNavItem(
        destination = TasksMainScreenDestination,
        label = R.string.destination_tasks,
        selectedIcon = Icons.Filled.TaskAlt,
        unselectedIcon = Icons.Outlined.TaskAlt
    )

    data object Add: BottomNavItem(
        destination = null,
        label = R.string.destination_add,
        selectedIcon = Icons.Filled.AddCircle,
        unselectedIcon = Icons.Filled.AddCircle
    )

    data object Projects: BottomNavItem(
        destination = ProjectsMainScreenDestination,
        label = R.string.destination_projects,
        selectedIcon = Icons.Filled.Work,
        unselectedIcon = Icons.Outlined.WorkOutline
    )

    data object Workspaces: BottomNavItem(
        destination = WorkspacesMainScreenDestination,
        label = R.string.destination_workspaces,
        selectedIcon = Icons.Filled.Folder,
        unselectedIcon = Icons.Outlined.Folder
    )


    companion object {
        fun values(): Set<BottomNavItem> = setOf(
            Notes,
            Tasks,
            Add,
            Projects,
            Workspaces
        )

        fun getSelectedItem(currentRoute: String?): BottomNavItem {
            return when(currentRoute) {
                Notes.destination!!.route -> Notes
                Tasks.destination!!.route -> Tasks
                Projects.destination!!.route -> Projects
                Workspaces.destination!!.route -> Workspaces
                else -> Notes
            }
        }

        fun showBottomNavBar(currentRoute: String?): Boolean {
            return when(currentRoute) {
                Notes.destination!!.route,
                Tasks.destination!!.route,
                Projects.destination!!.route,
                Workspaces.destination!!.route -> true
                else -> false
            }
        }
    }
}