package com.balitech.balinote.presentation.notes.notes_main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.balitech.balinote.core_ui.components.cards.TagCard
import com.balitech.balinote.core_ui.theme.dimensions.elevation
import com.balitech.balinote.core_ui.theme.dimensions.spacing
import com.balitech.balinote.domain.models.note.Note

@Composable
fun NotesVerticalStaggeredGrid(
    notes: List<Note>,
    columnsCount: Int,
    onItemClick: (Note) -> Unit,
    modifier: Modifier = Modifier,
    horizontalItemSpacing: Dp = MaterialTheme.spacing.medium,
    verticalItemSpacing: Dp = MaterialTheme.spacing.medium,
    contentPadding: Dp = MaterialTheme.spacing.medium
) {
    val notesListState = rememberLazyStaggeredGridState()

    LazyVerticalStaggeredGrid(
        state = notesListState,
        columns = StaggeredGridCells.Fixed(columnsCount),
        verticalItemSpacing = verticalItemSpacing,
        horizontalArrangement = Arrangement.spacedBy(horizontalItemSpacing),
        contentPadding = PaddingValues(contentPadding),
        modifier = modifier
    ) {
        items(
            items = notes,
            key = { note -> note.id }
        ) { note ->
            NoteCard(
                note = note,
                onClick = { onItemClick(note) }
            )
        }
    }
}

@Composable
private fun NoteCard(
    note: Note,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    darkTheme: Boolean = isSystemInDarkTheme(),
    shape: Shape = MaterialTheme.shapes.medium,
    tonalElevation: Dp = MaterialTheme.elevation.medium,
    titleStyle: TextStyle = MaterialTheme.typography.titleSmall,
    bodyStyle: TextStyle = MaterialTheme.typography.bodySmall,
    verticalSpacing: Dp = MaterialTheme.spacing.small,
    contentPadding: Dp = MaterialTheme.spacing.large,
    contentColor: Color = MaterialTheme.colorScheme.onBackground,
    titleMaxLines: Int = 2,
    bodyMaxLines: Int = 12
) {
    Surface(
        onClick = onClick,
        shape = shape,
        tonalElevation = tonalElevation,
        color = if (darkTheme) note.background.darkThemeValue else note.background.lightThemeValue,
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(verticalSpacing),
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentPadding)
        ) {
            Text(
                text = note.title,
                style = titleStyle,
                color = contentColor,
                maxLines = titleMaxLines,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = note.body,
                style = bodyStyle,
                color = contentColor.copy(alpha = 0.9f),
                maxLines = bodyMaxLines,
                overflow = TextOverflow.Ellipsis
            )


            Row(
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.spacing.extraSmall)
            ) {
                TagCard(tag = "BaliNote", verticalPadding = MaterialTheme.spacing.extraSmall)
                TagCard(tag = "BaliSafari", verticalPadding = MaterialTheme.spacing.extraSmall)
            }
        }
    }
}