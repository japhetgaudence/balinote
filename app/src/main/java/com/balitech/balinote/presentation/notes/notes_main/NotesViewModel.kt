package com.balitech.balinote.presentation.notes.notes_main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balitech.balinote.core_ui.types.ViewMode
import com.balitech.balinote.data.FakeNotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class NotesViewModel @Inject constructor(): ViewModel() {

    private val _uiState: MutableStateFlow<NotesScreenState> = MutableStateFlow(NotesScreenState())
    val uiState: StateFlow<NotesScreenState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.update { state -> state.copy(isLoading = true) }

            val notes = FakeNotesRepository.getNotes()
            val favoriteNotes = notes.filterIndexed { index, _ ->  index % 2 != 0 }
            val archivedNotes = notes.filterIndexed { index, _ ->  index % 2 == 0 }

            delay(1.seconds)

            _uiState.update { state ->
                state.copy(
                    notes = notes,
                    favoriteNotes = favoriteNotes,
                    archivedNotes = archivedNotes,
                    isLoading = false
                )
            }
        }
    }

    fun onStateEvent(event: NotesScreenEvent.StateEvent) {
        when(event) {
            is NotesScreenEvent.StateEvent.OnToggleNotesView -> {
                val targetViewMode = ViewMode.toggle(uiState.value.viewMode)
                _uiState.update { state -> state.copy(viewMode = targetViewMode) }
            }
        }
    }
}