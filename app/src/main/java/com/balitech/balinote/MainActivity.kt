package com.balitech.balinote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.balitech.balinote.core_ui.theme.BaliNoteTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.spec.NavHostEngine
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            BaliNoteTheme {
                val navController: NavHostController = rememberNavController()
                val navHostEngine: NavHostEngine = rememberAnimatedNavHostEngine()
                val coroutineScope: CoroutineScope = rememberCoroutineScope()

                MainScreen(
                    navController = navController,
                    navHostEngine = navHostEngine,
                    coroutineScope = coroutineScope
                )
            }
        }
    }
}


