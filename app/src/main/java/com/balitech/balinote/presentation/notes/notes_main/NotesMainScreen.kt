package com.balitech.balinote.presentation.notes.notes_main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.balitech.balinote.domain.models.common.BackgroundColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RootNavGraph(start = true)
@Destination
@Composable
fun NotesMainScreen(
    navigator: DestinationsNavigator
) {
    val listState = rememberLazyStaggeredGridState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        TestContent(state = listState)

    }
}


@Composable
fun TestContent(
    state: LazyStaggeredGridState,
) {
    val backgrounds = BackgroundColor.getAll()
    val items = backgrounds.plus(backgrounds).plus(backgrounds)

    LazyVerticalStaggeredGrid(
        state = state,
        modifier = Modifier.fillMaxSize(),
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalItemSpacing = 12.dp,
        contentPadding = PaddingValues(12.dp)
    ) {
        itemsIndexed(items = items, key = { index, _ -> index }) { _, item ->
            Container(background = item)
        }
    }
}

@Composable
fun Container(
    background: BackgroundColor,
    modifier: Modifier = Modifier,
    darkTheme: Boolean = isSystemInDarkTheme(),
    shape: Shape = MaterialTheme.shapes.medium,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    borderWidth: Dp = if (BackgroundColor.isNone(background)) 1.dp else Dp.Unspecified,
    borderColor: Color = if (BackgroundColor.isNone(background)) DividerDefaults.color else Color.Unspecified
) {
    val text = "Build a custom color scheme to map dynamic color, use as fallback colors, or implement a branded theme. The color system automatically handles critical adjustments that provide accessible color contrast."


    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .border(width = borderWidth, color = borderColor, shape = shape)
            .background(if (darkTheme) background.darkThemeValue else background.lightThemeValue)
            .padding(12.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = textColor
        )
    }
}
