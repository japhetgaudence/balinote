package com.balitech.balinote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.balitech.balinote.presentation.NavGraphs
import com.balitech.balinote.presentation.appCurrentDestinationAsState
import com.balitech.balinote.presentation.destinations.Destination
import com.balitech.balinote.presentation.startAppDestination
import com.balitech.balinote.ui.components.appbars.BottomNavigationBar
import com.balitech.balinote.ui.navigation.BottomNavItem
import com.balitech.balinote.ui.theme.BaliNoteTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.spec.NavHostEngine

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            BaliNoteTheme {
                App()
            }
        }
    }
}

@OptIn(
    ExperimentalMaterialNavigationApi::class,
    ExperimentalAnimationApi::class,
)
@Composable
fun App(
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.background
) {
    val navHostEngine: NavHostEngine = rememberAnimatedNavHostEngine()
    val navController: NavHostController = navHostEngine.rememberNavController()

    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination


    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = background,
        bottomBar = {
            BottomNavigationBar(
                selectedItem = BottomNavItem.getItem(currentDestination.route),
                onItemClick = { item: BottomNavItem ->
                    if (item == BottomNavItem.Add) {
                        // TODO: Implement add bottom sheet
                        return@BottomNavigationBar
                    } else {
                        navController.navigate(item.route) {
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    ) { contentPadding: PaddingValues ->
        DestinationsNavHost(
            navController = navController,
            engine = navHostEngine,
            navGraph = NavGraphs.root,
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        )
    }
}