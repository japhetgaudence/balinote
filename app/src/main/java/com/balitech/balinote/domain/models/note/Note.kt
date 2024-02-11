package com.balitech.balinote.domain.models.note

import com.balitech.balinote.domain.models.common.BackgroundColor
import com.balitech.balinote.domain.models.common.Tag
import com.balitech.balinote.domain.models.project.Project
import com.balitech.balinote.domain.models.workspace.Workspace
import java.time.LocalDateTime

data class Note(
    val id: String = "",
    val title: String = "",
    val body: String = "",
    val isPinned: Boolean = false,
    val isFavorite: Boolean = false,
    val isArchived: Boolean = false,
    val project: Project? = null,
    val tags: List<Tag> = emptyList(),
    val workspace: Workspace? = null,
    val background: BackgroundColor = BackgroundColor.None,
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val createdAt: LocalDateTime = LocalDateTime.now()
)

/*
* NOTES USECASES:-
* Search notes
* Sort by       : Date created & Date modified (asc-desc), color,
* Change layout : SingleColumn, GridLayout, StaggeredGridLayout
* */