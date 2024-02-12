package com.balitech.balinote.core_ui.navigation

import androidx.navigation.NavHostController
import com.balitech.balinote.presentation.NavGraphs
import com.balitech.balinote.presentation.destinations.RemindersScreenDestination
import com.balitech.balinote.presentation.destinations.SearchScreenDestination
import com.balitech.balinote.presentation.destinations.SettingsScreenDestination
import com.balitech.balinote.presentation.startAppDestination
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.Direction


fun NavHostController.navigateBottomNavBar(destination: Direction) {
    this.navigate(destination) {
        launchSingleTop = true
        popUpTo(NavGraphs.root.startAppDestination.route)
    }
}

fun NavHostController.navigateToSearchScreen() {
    this.navigate(SearchScreenDestination) {
        launchSingleTop = true
    }
}

fun NavHostController.navigateToRemindersScreen() {
    this.navigate(RemindersScreenDestination) {
        launchSingleTop = true
    }
}

fun NavHostController.navigateToSettingsScreen() {
    this.navigate(SettingsScreenDestination) {
        launchSingleTop = true
    }
}

fun NavHostController.navigateSingleTop(destination: Direction, popupToRoute: String? = null) {
    if (popupToRoute == null) {
        this.navigate(destination) {
            launchSingleTop = true
        }
    } else {
        this.navigate(destination) {
            launchSingleTop = true
            popUpTo(popupToRoute)
        }
    }
}