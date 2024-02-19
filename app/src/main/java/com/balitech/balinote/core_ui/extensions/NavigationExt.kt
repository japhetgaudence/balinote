package com.balitech.balinote.core_ui.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.balitech.balinote.core_ui.types.BottomNavItem
import com.balitech.balinote.presentation.NavGraphs
import com.balitech.balinote.presentation.destinations.RemindersScreenDestination
import com.balitech.balinote.presentation.destinations.SearchScreenDestination
import com.balitech.balinote.presentation.destinations.SettingsScreenDestination
import com.balitech.balinote.presentation.startAppDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.Direction


@Stable
@Composable
fun NavHostController.hideAppBarsAsState(): State<Boolean> {
    val hideAppBars = rememberSaveable { mutableStateOf(false) }

    DisposableEffect(key1 = this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            hideAppBars.value = when {
                destination.hierarchy.any { it.route == BottomNavItem.Notes.destination?.route } ||
                        destination.hierarchy.any { it.route == BottomNavItem.Tasks.destination?.route } ||
                        destination.hierarchy.any { it.route == BottomNavItem.Projects.destination?.route } ||
                        destination.hierarchy.any { it.route == BottomNavItem.Account.destination?.route } -> {
                    false
                }

                else -> true
            }

        }
        addOnDestinationChangedListener(listener)
        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }

    return hideAppBars
}


fun NavHostController.navigateBottomNavBar(destination: Direction) {
    this.navigate(destination) {
        launchSingleTop = true
        val state = saveState()

        popUpTo(NavGraphs.root.startAppDestination.route) {
            restoreState(state)
        }
    }
}


fun DestinationsNavigator.navigateToSearchScreen() {
    this.navigate(SearchScreenDestination) {
        launchSingleTop = true
    }
}


fun DestinationsNavigator.navigateToRemindersScreen() {
    this.navigate(RemindersScreenDestination) {
        launchSingleTop = true
    }
}


fun DestinationsNavigator.navigateToSettingsScreen() {
    this.navigate(SettingsScreenDestination) {
        launchSingleTop = true
    }
}


fun DestinationsNavigator.navigateSingleTop(destination: Direction, popupToRoute: String? = null) {
    if (popupToRoute == null) {
        this.navigate(destination) { launchSingleTop = true }
    } else {
        this.navigate(destination) {
            launchSingleTop = true
            popUpTo(popupToRoute)
        }
    }
}



