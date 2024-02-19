package com.balitech.balinote.presentation.notes.notes_main

import com.balitech.balinote.core_ui.types.ViewMode
import com.balitech.balinote.domain.models.note.Note

data class NotesScreenState(
    val isLoading: Boolean = false,
    val viewMode: ViewMode = ViewMode.Grid,
    val notes: List<Note> = emptyList(),
    val favoriteNotes: List<Note> = emptyList(),
    val archivedNotes: List<Note> = emptyList(),
)
