package com.balitech.balinote.presentation.tasks.tasks_main

import com.balitech.balinote.core_ui.types.ViewMode
import com.balitech.balinote.domain.models.task.Task

data class TasksScreenState(
    val isLoading: Boolean = false,
    val viewMode: ViewMode = ViewMode.Grid,
    val tasks: List<Task> = emptyList(),
)
