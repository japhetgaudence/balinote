package com.balitech.balinote.presentation.notes.notes_main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.balitech.balinote.R
import com.balitech.balinote.core_ui.components.layouts.TopDestinationScaffold
import com.balitech.balinote.core_ui.extensions.navigateSingleTop
import com.balitech.balinote.core_ui.extensions.navigateToRemindersScreen
import com.balitech.balinote.core_ui.extensions.navigateToSearchScreen
import com.balitech.balinote.domain.models.note.Note
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@RootNavGraph(start = true)
@Destination
@Composable
fun NotesMainScreen(
    navigator: DestinationsNavigator
) {
    val viewModel: NotesViewModel = hiltViewModel()
    val uiState: NotesScreenState = viewModel.uiState.collectAsStateWithLifecycle().value

    NotesMainScreenContent(
        uiState = uiState,
        onStateEvent = viewModel::onStateEvent,
        onNavigationEvent = { event: NotesScreenEvent.NavigationEvent ->
            when (event) {
                is NotesScreenEvent.NavigationEvent.OnNavigateToNoteDetailsScreen -> {
                    navigator.navigateSingleTop(event.direction)
                }

                is NotesScreenEvent.NavigationEvent.OnNavigateToRemindersScreen -> {
                    navigator.navigateToRemindersScreen()
                }

                is NotesScreenEvent.NavigationEvent.OnNavigateToSearchScreen -> {
                    navigator.navigateToSearchScreen()
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun NotesMainScreenContent(
    uiState: NotesScreenState,
    onStateEvent: (event: NotesScreenEvent.StateEvent) -> Unit,
    onNavigationEvent: (event: NotesScreenEvent.NavigationEvent) -> Unit,
) {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val pagerState =
        rememberPagerState(initialPage = NotesTab.firstTabIndex(), pageCount = { NotesTab.count })
    val selectedTabIndex by rememberSaveable(pagerState.currentPage) { mutableIntStateOf(pagerState.currentPage) }

    TopDestinationScaffold(
        title = R.string.label_notes,
        viewMode = uiState.viewMode,
        scrollBehavior = scrollBehavior,
        onToggleViewClick = {
            onStateEvent(NotesScreenEvent.StateEvent.OnToggleNotesView)
        },
        onSearchIconClick = {
            onNavigationEvent(NotesScreenEvent.NavigationEvent.OnNavigateToSearchScreen)
        },
        onNotificationIconClick = {
            onNavigationEvent(NotesScreenEvent.NavigationEvent.OnNavigateToRemindersScreen)
        },
        tabsContent = {
            NotesTabRow(
                selectedTabIndex = selectedTabIndex,
                onTabClick = { index: Int ->
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    ) {
        if (uiState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Loading...")
            }
        }

        NotesViewPager(
            state = pagerState,
            scrollConnection = scrollBehavior.nestedScrollConnection,
            allNotesPage = {
                NotesVerticalStaggeredGrid(
                    notes = uiState.notes,
                    columnsCount = uiState.viewMode.columnsCount,
                    onItemClick = { note: Note ->
                        val event = NotesScreenEvent.NavigationEvent
                            .OnNavigateToNoteDetailsScreen(note.id)
                        onNavigationEvent(event)
                    }
                )
            },
            favoriteNotesPage = {
                NotesVerticalStaggeredGrid(
                    notes = uiState.favoriteNotes,
                    columnsCount = uiState.viewMode.columnsCount,
                    onItemClick = { note: Note ->
                        val event = NotesScreenEvent.NavigationEvent
                            .OnNavigateToNoteDetailsScreen(note.id)
                        onNavigationEvent(event)
                    }
                )
            },
            archivedNotesPage = {
                NotesVerticalStaggeredGrid(
                    notes = uiState.archivedNotes,
                    columnsCount = uiState.viewMode.columnsCount,
                    onItemClick = { note: Note ->
                        val event = NotesScreenEvent.NavigationEvent
                            .OnNavigateToNoteDetailsScreen(note.id)
                        onNavigationEvent(event)
                    }
                )
            },
            foldersPage = {}
        )
    }
}
