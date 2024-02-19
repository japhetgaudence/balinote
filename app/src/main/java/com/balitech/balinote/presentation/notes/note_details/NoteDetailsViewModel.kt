package com.balitech.balinote.presentation.notes.note_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.balitech.balinote.data.FakeNotesRepository
import com.balitech.balinote.domain.models.note.Note
import com.balitech.balinote.presentation.navArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val navArgs: NoteDetailsScreenNavArgs = savedStateHandle.navArgs()
    val note: Note? =
        if (navArgs.noteId == null) Note() else FakeNotesRepository.getNoteById(navArgs.noteId)

}