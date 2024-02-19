package com.balitech.balinote.presentation.notes.notes_main

import com.balitech.balinote.presentation.destinations.NoteDetailsScreenDestination

sealed interface NotesScreenEvent {

    sealed interface StateEvent: NotesScreenEvent {
        data object OnToggleNotesView: StateEvent
    }

    sealed interface NavigationEvent: NotesScreenEvent {
        data object OnNavigateToRemindersScreen: NavigationEvent

        data object OnNavigateToSearchScreen: NavigationEvent

        data class OnNavigateToNoteDetailsScreen(val noteId: String?): NavigationEvent {
            val direction = NoteDetailsScreenDestination(noteId = noteId)
        }
    }

}