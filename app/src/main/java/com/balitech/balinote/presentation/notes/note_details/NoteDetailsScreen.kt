package com.balitech.balinote.presentation.notes.note_details

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.balitech.balinote.NoteFoundScreen
import com.balitech.balinote.R
import com.balitech.balinote.core_ui.components.markdown.MarkDownEditor
import com.balitech.balinote.core_ui.theme.dimensions.spacing
import com.balitech.balinote.domain.models.note.Note
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination(navArgsDelegate = NoteDetailsScreenNavArgs::class)
@Composable
fun NoteDetailsScreen(
    navigator: DestinationsNavigator,
) {
    val viewModel = hiltViewModel<NoteDetailsViewModel>()
    val note: Note? = viewModel.note

    if (note == null) {
        NoteFoundScreen(
            title = "Note Not Found",
            description = "Oops!, could not retrieve note"
        )
    } else {
        NoteDetailsScreenContent(
            note = note,
            onNavigateUp = { navigator.navigateUp() },
            onStateEvent = {

            }
        )
    }
}


@Composable
fun NoteDetailsScreenContent(
    note: Note,
    onNavigateUp: () -> Unit,
    onStateEvent: (NoteDetailsScreenEvent.StateEvent) -> Unit,
    modifier: Modifier = Modifier,
    verticalSpacing: Dp = MaterialTheme.spacing.large,
    contentPadding: Dp = MaterialTheme.spacing.large,
    darkTheme: Boolean = isSystemInDarkTheme()
) {
    val state: LazyListState = rememberLazyListState()
    var titleValue: TextFieldValue by remember {
        mutableStateOf(TextFieldValue(text = note.title))
    }
    var bodyValue: TextFieldValue by remember {
        mutableStateOf(TextFieldValue(text = note.body))
    }

    Scaffold(
        topBar = {
            NoteDetailsScreenTopBar(
                onNavigateUp = onNavigateUp,
                onPinNote = { onStateEvent(NoteDetailsScreenEvent.StateEvent.OnPinNote)},
                onArchiveNote = { onStateEvent(NoteDetailsScreenEvent.StateEvent.OnArchiveNote)},
                onContextMenuClick = { onStateEvent(NoteDetailsScreenEvent.StateEvent.OnShowContextMenu)},
            )
        },
        containerColor = if (darkTheme) note.background.darkThemeValue else note.background.lightThemeValue,
        modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.ime)
    ) { scaffoldPadding: PaddingValues ->
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = scaffoldPadding.calculateTopPadding())
        ) {
            LazyColumn(
                state = state,
                contentPadding = PaddingValues(contentPadding),
                verticalArrangement = Arrangement.spacedBy(verticalSpacing),
                modifier = modifier
            ) {
                item {
                    MarkDownEditor(
                        value = titleValue,
                        onValueChange = { newValue ->
                            titleValue = newValue
                        },
                        textStyle = MaterialTheme.typography.headlineLarge,
                        hint = stringResource(id = R.string.hint_title),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    MarkDownEditor(
                        value = bodyValue,
                        onValueChange = { newValue ->
                            bodyValue = newValue
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }

}


