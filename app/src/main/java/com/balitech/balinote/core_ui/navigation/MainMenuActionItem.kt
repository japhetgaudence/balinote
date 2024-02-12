package com.balitech.balinote.core_ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Label
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.balitech.balinote.R
import com.balitech.balinote.presentation.destinations.ArchiveScreenDestination
import com.balitech.balinote.presentation.destinations.RemindersScreenDestination
import com.balitech.balinote.presentation.destinations.SettingsScreenDestination
import com.balitech.balinote.presentation.destinations.TagsMainScreenDestination
import com.ramcosta.composedestinations.spec.Direction

sealed class MainMenuActionItem(
    val direction: Direction,
    @StringRes val label: Int,
    val icon: ImageVector
) {
    data object NavigateToTagsScreen: MainMenuActionItem(
        direction = TagsMainScreenDestination,
        label = R.string.label_tags,
        icon = Icons.AutoMirrored.Outlined.Label
    )

    data object NavigateToArchiveScreen: MainMenuActionItem(
        direction = ArchiveScreenDestination,
        label = R.string.label_archive,
        icon = Icons.Outlined.Archive
    )

    data object NavigateToRemindersScreen: MainMenuActionItem(
        direction = RemindersScreenDestination,
        label = R.string.label_reminders,
        icon = Icons.Outlined.Notifications
    )

    data object NavigateToSettingsScreen: MainMenuActionItem(
        direction = SettingsScreenDestination,
        label = R.string.label_settings,
        icon = Icons.Outlined.Settings
    )


    companion object {
        fun values(): List<MainMenuActionItem> = listOf(
            NavigateToTagsScreen,
            NavigateToArchiveScreen,
            NavigateToRemindersScreen,
            NavigateToSettingsScreen
        )
    }
}