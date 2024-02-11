package com.balitech.balinote.domain.models.project

import com.balitech.balinote.domain.models.common.Priority
import com.balitech.balinote.domain.models.common.Status
import com.balitech.balinote.domain.models.note.Note
import com.balitech.balinote.domain.models.task.Task
import com.balitech.balinote.domain.models.workspace.Workspace
import java.time.LocalDateTime

data class Project(
    val id: String = "",
    val name: String = "",
    val description: String? = null,
    val workspace: Workspace? = null,
    val status: Status = Status.Created,
    val priority: Priority = Priority.None,
    val notes: List<Note> = emptyList(),
    val tasks: List<Task> = emptyList(),
    val isPinned: Boolean = false,
    val startsAt: LocalDateTime = LocalDateTime.now(),
    val endsAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val createdAt: LocalDateTime = LocalDateTime.now()
)
