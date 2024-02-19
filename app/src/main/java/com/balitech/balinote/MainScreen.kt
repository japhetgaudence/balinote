package com.balitech.balinote

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.balitech.balinote.core_ui.components.appbars.BottomNavigationBar
import com.balitech.balinote.core_ui.components.sheets.CreateResourceBottomSheet
import com.balitech.balinote.core_ui.components.sheets.MainMenuBottomSheet
import com.balitech.balinote.core_ui.types.BottomNavItem
import com.balitech.balinote.core_ui.extensions.hideAppBarsAsState
import com.balitech.balinote.core_ui.extensions.navigateBottomNavBar
import com.balitech.balinote.presentation.NavGraphs
import com.balitech.balinote.presentation.appCurrentDestinationAsState
import com.balitech.balinote.presentation.destinations.Destination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.Direction
import com.ramcosta.composedestinations.spec.NavHostEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navHostEngine: NavHostEngine,
    navController: NavHostController,
    coroutineScope: CoroutineScope,
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.background,
) {
    val hideAppBars by navController.hideAppBarsAsState()
    val currentDestination: Destination? = navController.appCurrentDestinationAsState().value
    val selectedBottomNavItem = BottomNavItem.getSelectedItem(currentDestination?.route)

    val createResourceSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showCreateResourceBottomSheet by rememberSaveable { mutableStateOf(false) }

    val mainMenuSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showMainMenuBottomSheet by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            if (!hideAppBars) {
                BottomNavigationBar(
                    selectedDestination = selectedBottomNavItem,
                    onItemClick = { item: BottomNavItem ->
                        if (item == BottomNavItem.Create) {
                            showCreateResourceBottomSheet = true
                        } else {
                            navController.navigateBottomNavBar(item.destination!!)
                        }
                    }
                )
            }
        },
        containerColor = background,
        modifier = modifier.fillMaxSize()
    ) {
        DestinationsNavHost(
            navController = navController,
            engine = navHostEngine,
            navGraph = NavGraphs.root,
            modifier = Modifier.fillMaxSize()
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