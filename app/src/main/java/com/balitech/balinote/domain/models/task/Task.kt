package com.balitech.balinote.domain.models.task

import com.balitech.balinote.domain.models.common.Priority
import com.balitech.balinote.domain.models.common.Status
import com.balitech.balinote.domain.models.project.Project
import com.balitech.balinote.domain.models.workspace.Workspace
import java.time.LocalDateTime



data class Task(
    val id: String = "",
    val name: String = "",
    val description: String? = null,
    val project: Project? = null,
    val workspace: Workspace? = null,
    val isPinned: Boolean = false,
    val status: Status = Status.Created,
    val priority: Priority = Priority.None,
    val todos: List<Todo> = emptyList(),
    val startsAt: LocalDateTime = LocalDateTime.now(),
    val endsAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val createdAt: LocalDateTime = LocalDateTime.now()
)