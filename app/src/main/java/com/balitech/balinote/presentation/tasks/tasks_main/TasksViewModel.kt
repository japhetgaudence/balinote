package com.balitech.balinote.presentation.tasks.tasks_main

import androidx.lifecycle.ViewModel
import com.balitech.balinote.core_ui.types.ViewMode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(): ViewModel() {

    private val _uiState: MutableStateFlow<TasksScreenState> = MutableStateFlow(TasksScreenState())
    val uiState: StateFlow<TasksScreenState> = _uiState

    fun onStateEvent(event: TasksScreenEvent.StateEvent) {
        when(event) {
            is TasksScreenEvent.StateEvent.OnToggleNotesView -> {
                val targetViewMode = ViewMode.toggle(uiState.value.viewMode)
                _uiState.update { state -> state.copy(viewMode = targetViewMode) }
            }
        }
    }

}