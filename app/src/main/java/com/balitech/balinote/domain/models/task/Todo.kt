package com.balitech.balinote.domain.models.task

import com.balitech.balinote.domain.models.common.Priority
import java.time.LocalDateTime

data class Todo(
    val id: String = "",
    val name: String = "",
    val description: String? = null,
    val isCompleted: Boolean = false,
    val priority: Priority = Priority.None,
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val createdAt: LocalDateTime = LocalDateTime.now()
)
