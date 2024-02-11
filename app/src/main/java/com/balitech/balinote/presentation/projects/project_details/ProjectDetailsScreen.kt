package com.balitech.balinote.presentation.projects.project_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@Composable
fun ProjectDetailsScreen(
    navigator: DestinationsNavigator
) {
     Box(
         contentAlignment = Alignment.Center,
         modifier = Modifier.fillMaxSize()
     ) {
         Text(text = "Project Details Screen")
     }
}