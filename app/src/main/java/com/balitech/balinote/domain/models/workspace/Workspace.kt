package com.balitech.balinote.domain.models.workspace

import com.balitech.balinote.domain.models.project.Project
import com.balitech.balinote.domain.models.task.Task
import java.time.LocalDateTime

data class Workspace(
    val id: String = "",
    val name: String = "",
    val description: String? = null,
    val tasks: List<Task> = emptyList(),
    val notes: List<Project> = emptyList(),
    val projects: List<Project> = emptyList(),
    val isPinned: Boolean = false,
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val createdAt: LocalDateTime = LocalDateTime.now()
)
