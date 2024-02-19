package com.balitech.balinote.presentation.tasks.tasks_main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.balitech.balinote.R
import com.balitech.balinote.core_ui.components.layouts.TopDestinationScaffold
import com.balitech.balinote.core_ui.extensions.navigateToRemindersScreen
import com.balitech.balinote.core_ui.extensions.navigateToSearchScreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.CoroutineScope


@RootNavGraph
@Destination
@Composable
fun TasksMainScreen(
    navigator: DestinationsNavigator
) {
    val viewModel: TasksViewModel = hiltViewModel()
    val uiState: TasksScreenState = viewModel.uiState.collectAsStateWithLifecycle().value

    TasksScreenContent(
        uiState = uiState,
        onStateEvent = viewModel::onStateEvent,
        onNavigationEvent = { event: TasksScreenEvent.NavigationEvent ->
            when (event) {
                is TasksScreenEvent.NavigationEvent.OnNavigateToRemindersScreen -> {
                    navigator.navigateToRemindersScreen()
                }

                is TasksScreenEvent.NavigationEvent.OnNavigateToSearchScreen -> {
                    navigator.navigateToSearchScreen()
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreenContent(
    uiState: TasksScreenState,
    onStateEvent: (event: TasksScreenEvent.StateEvent) -> Unit,
    onNavigationEvent: (event: TasksScreenEvent.NavigationEvent) -> Unit,
) {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    TopDestinationScaffold(
        title = R.string.label_tasks,
        viewMode = uiState.viewMode,
        scrollBehavior = scrollBehavior,
        onToggleViewClick = {
            onStateEvent(TasksScreenEvent.StateEvent.OnToggleNotesView)
        },
        onSearchIconClick = {
            onNavigationEvent(TasksScreenEvent.NavigationEvent.OnNavigateToSearchScreen)
        },
        onNotificationIconClick = {
            onNavigationEvent(TasksScreenEvent.NavigationEvent.OnNavigateToRemindersScreen)
        },
        tabsContent = { /*TODO*/ }
    ) {
    }
}

