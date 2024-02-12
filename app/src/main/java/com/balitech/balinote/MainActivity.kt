package com.balitech.balinote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.balitech.balinote.core_ui.components.appbars.BottomNavigationBar
import com.balitech.balinote.core_ui.components.appbars.TopNavigationBar
import com.balitech.balinote.core_ui.components.sheets.CreateResourceBottomSheet
import com.balitech.balinote.core_ui.components.sheets.MainMenuBottomSheet
import com.balitech.balinote.core_ui.navigation.BottomNavItem
import com.balitech.balinote.core_ui.navigation.TopNavBarAction
import com.balitech.balinote.core_ui.navigation.navigateBottomNavBar
import com.balitech.balinote.core_ui.navigation.navigateToRemindersScreen
import com.balitech.balinote.core_ui.navigation.navigateToSearchScreen
import com.balitech.balinote.core_ui.theme.BaliNoteTheme
import com.balitech.balinote.presentation.NavGraphs
import com.balitech.balinote.presentation.appCurrentDestinationAsState
import com.balitech.balinote.presentation.destinations.Destination
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.Direction
import com.ramcosta.composedestinations.spec.NavHostEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            BaliNoteTheme {
                val navHostEngine: NavHostEngine = rememberAnimatedNavHostEngine()
                val navController: NavHostController = navHostEngine.rememberNavController()
                val coroutineScope: CoroutineScope = rememberCoroutineScope()

                App(
                    navHostEngine = navHostEngine,
                    navController = navController,
                    coroutineScope = coroutineScope
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class,)
@Composable
fun App(
    navHostEngine: NavHostEngine,
    navController: NavHostController,
    coroutineScope: CoroutineScope,
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.background,
) {
    val currentDestination: Destination? = navController.appCurrentDestinationAsState().value
    val selectedDestination = BottomNavItem.getSelectedItem(currentDestination?.route)
    val showBottomNavBar: Boolean = BottomNavItem.showBottomNavBar(currentDestination?.route)

    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(state = topAppBarState)

    val createResourceSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showCreateResourceBottomSheet by rememberSaveable { mutableStateOf(false) }

    val mainMenuSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showMainMenuBottomSheet by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            AnimatedVisibility(
                visible = showBottomNavBar,
                enter = slideInVertically { offsetY -> -(offsetY) },
                exit = slideOutVertically { offsetY -> -(offsetY) }
            ) {
                TopNavigationBar(
                    title = stringResource(id = selectedDestination.label),
                    scrollBehavior = scrollBehavior,
                    onActionClick = { action: TopNavBarAction ->
                        when(action) {
                            TopNavBarAction.NavigateToRemindersScreen -> {
                                navController.navigateToRemindersScreen()
                            }
                            TopNavBarAction.NavigateToSearchScreen -> {
                                navController.navigateToSearchScreen()
                            }
                            TopNavBarAction.ToggleContextMenu -> {
                                showMainMenuBottomSheet = true
                            }
                            TopNavBarAction.ToggleLayout -> Unit
                        }
                    },
                )
            }
        },
        bottomBar = {
            AnimatedVisibility(
                visible = showBottomNavBar,
                enter = slideInVertically { offsetY -> offsetY },
                exit = slideOutVertically { offsetY -> offsetY }
            ) {
                BottomNavigationBar(
                    selectedDestination = selectedDestination,
                    onItemClick = { item: BottomNavItem ->
                        if (item == BottomNavItem.Add) {
                            showCreateResourceBottomSheet = true
                        } else {
                            navController.navigateBottomNavBar(item.destination!!)
                        }
                    }
                )
            }
        },
        containerColor = background,
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { contentPadding: PaddingValues ->
        DestinationsNavHost(
            navController = navController,
            engine = navHostEngine,
            navGraph = NavGraphs.root,
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        )

        if (showCreateResourceBottomSheet) {
            CreateResourceBottomSheet(
                sheetState = createResourceSheetState,
                onDismissRequest = { showCreateResourceBottomSheet = false },
                onNavigate = { direction: Direction ->
                    coroutineScope
                        .launch { createResourceSheetState.hide() }
                        .invokeOnCompletion {
                            if (!createResourceSheetState.isVisible)
                                showCreateResourceBottomSheet = false

                            navController.navigate(direction)
                        }
                }
            )
        }

        if (showMainMenuBottomSheet) {
            MainMenuBottomSheet(
                sheetState = mainMenuSheetState,
                onDismissRequest = { showMainMenuBottomSheet = false },
                onNavigate = { direction: Direction ->
                    coroutineScope
                        .launch { mainMenuSheetState.hide() }
                        .invokeOnCompletion {
                            if (!mainMenuSheetState.isVisible)
                                showMainMenuBottomSheet = false

                            navController.navigate(direction)
                        }
                }
            )
        }
    }
}


/*
* Context Menu Options:
*    - Sort
*    - Tags
*    - Archive
*    - Settings
* */