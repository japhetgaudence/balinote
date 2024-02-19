package com.balitech.balinote.presentation.tasks.tasks_main

import androidx.annotation.StringRes
import com.balitech.balinote.R

sealed class TasksTab(
    @StringRes val label: Int
) {
    data object All : TasksTab(R.string.label_all)

    data object Important : TasksTab(R.string.label_important)

    data object Archived : TasksTab(R.string.label_archived)

    data object Folders : TasksTab(R.string.label_folders)

    companion object {
        val count: Int = values().size

        fun firstTabIndex(tab: TasksTab = All): Int = values().indexOf(tab)

        fun values(): List<TasksTab> = listOf(All, Important, Archived, Folders)
    }
}