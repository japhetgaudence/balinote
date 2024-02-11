package com.balitech.balinote.presentation.notes.note_details

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
fun NoteDetailsScreen(
    navigator: DestinationsNavigator
) {
     Box(
         contentAlignment = Alignment.Center,
         modifier = Modifier.fillMaxSize()
     ) {
         Text(text = "Note Details Screen")
     }
}