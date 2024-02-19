package com.balitech.balinote.core_ui.types

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.NoteAlt
import androidx.compose.material.icons.outlined.TaskAlt
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.ui.graphics.vector.ImageVector
import com.balitech.balinote.R
import com.balitech.balinote.presentation.destinations.AccountMainScreenDestination
import com.balitech.balinote.presentation.destinations.NotesMainScreenDestination
import com.balitech.balinote.presentation.destinations.ProjectsMainScreenDestination
import com.balitech.balinote.presentation.destinations.TasksMainScreenDestination
import com.ramcosta.composedestinations.spec.Direction

sealed class BottomNavItem(
    val destination: Direction?,
    @StringRes val label: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {

    data object Notes: BottomNavItem(
        destination = NotesMainScreenDestination,
        label = R.string.label_notes,
        selectedIcon = Icons.Filled.NoteAlt,
        unselectedIcon = Icons.Outlined.NoteAlt
    )

    data object Tasks: BottomNavItem(
        destination = TasksMainScreenDestination,
        label = R.string.label_tasks,
        selectedIcon = Icons.Filled.TaskAlt,
        unselectedIcon = Icons.Outlined.TaskAlt
    )

    data object Create: BottomNavItem(
        destination = null,
        label = R.string.label_create,
        selectedIcon = Icons.Filled.AddCircle,
        unselectedIcon = Icons.Filled.AddCircle
    )

    data object Projects: BottomNavItem(
        destination = ProjectsMainScreenDestination,
        label = R.string.label_projects,
        selectedIcon = Icons.Filled.Work,
        unselectedIcon = Icons.Outlined.WorkOutline
    )

    data object Account: BottomNavItem(
        destination = AccountMainScreenDestination,
        label = R.string.label_account,
        selectedIcon = Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle
    )


    companion object {
        fun values(): Set<BottomNavItem> = setOf(
            Notes,
            Tasks,
            Create,
            Projects,
            Account
        )

        fun getSelectedItem(currentRoute: String?): BottomNavItem {
            return when(currentRoute) {
                Notes.destination!!.route -> Notes
                Tasks.destination!!.route -> Tasks
                Projects.destination!!.route -> Projects
                Account.destination!!.route -> Account
                else -> Notes
            }
        }
    }
}