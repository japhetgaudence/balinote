package com.balitech.balinote.presentation.notes.notes_main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import com.balitech.balinote.core_ui.theme.dimensions.spacing

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotesViewPager(
    state: PagerState,
    scrollConnection: NestedScrollConnection,
    modifier: Modifier = Modifier,
    tabs: List<NotesTab> = NotesTab.values(),
    allNotesPage: @Composable () -> Unit,
    favoriteNotesPage: @Composable () -> Unit,
    archivedNotesPage: @Composable () -> Unit,
    foldersPage: @Composable () -> Unit,
    contentPadding: PaddingValues = PaddingValues(top = MaterialTheme.spacing.extraSmall)
) {
    HorizontalPager(
        state = state,
        pageNestedScrollConnection = scrollConnection,
        modifier = modifier,
        contentPadding = contentPadding
    ) { pageIndex: Int ->
        when (tabs[pageIndex]) {
            NotesTab.All -> allNotesPage()
            NotesTab.Archived -> archivedNotesPage()
            NotesTab.Favorites -> favoriteNotesPage()
            NotesTab.Folders -> foldersPage()
        }
    }
}