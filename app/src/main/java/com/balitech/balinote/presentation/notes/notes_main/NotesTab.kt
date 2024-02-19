package com.balitech.balinote.presentation.notes.notes_main

import androidx.annotation.StringRes
import com.balitech.balinote.R

sealed class NotesTab(
    @StringRes val label: Int
) {
    data object All : NotesTab(R.string.label_all)
    data object Favorites : NotesTab(R.string.label_favorites)
    data object Archived : NotesTab(R.string.label_archived)
    data object Folders : NotesTab(R.string.label_folders)

    companion object {
        val count: Int = values().size

        fun firstTabIndex(tab: NotesTab = All): Int = values().indexOf(tab)

        fun values(): List<NotesTab> = listOf(All, Favorites, Archived, Folders)
    }
}