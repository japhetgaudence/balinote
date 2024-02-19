package com.balitech.balinote.presentation.tasks.tasks_main

sealed interface TasksScreenEvent {

    sealed interface StateEvent: TasksScreenEvent {
        data object OnToggleNotesView: StateEvent
    }

    sealed interface NavigationEvent: TasksScreenEvent {
        data object OnNavigateToRemindersScreen: NavigationEvent

        data object OnNavigateToSearchScreen: NavigationEvent

    }

}