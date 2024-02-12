package com.balitech.balinote.core_ui.navigation

sealed interface TopNavBarAction {
    data object NavigateToRemindersScreen: TopNavBarAction
    data object NavigateToSearchScreen: TopNavBarAction
    data object ToggleLayout: TopNavBarAction
    data object ToggleContextMenu: TopNavBarAction
}