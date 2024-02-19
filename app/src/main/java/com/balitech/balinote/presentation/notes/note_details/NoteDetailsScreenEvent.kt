package com.balitech.balinote.presentation.notes.note_details

sealed interface NoteDetailsScreenEvent {

    sealed interface StateEvent: NoteDetailsScreenEvent {
        data object OnPinNote: StateEvent
        data object OnArchiveNote: StateEvent
        data object OnShowContextMenu: StateEvent
    }

    sealed interface OneTimeEvent: NoteDetailsScreenEvent {
        data object NewNote: OneTimeEvent

        data object NotNotFound: OneTimeEvent
    }
}