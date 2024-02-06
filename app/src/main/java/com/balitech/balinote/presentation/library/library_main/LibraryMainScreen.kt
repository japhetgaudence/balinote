package com.balitech.balinote.presentation.library.library_main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

const val LIBRARY_MAIN_SCREEN_ROUTE = "library/main"

@RootNavGraph
@Destination(route = LIBRARY_MAIN_SCREEN_ROUTE)
@Composable
fun LibraryMainScreen(
    navigator: DestinationsNavigator
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Library Screen")
    }
}