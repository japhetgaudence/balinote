package com.balitech.balinote.core_ui.theme.dimensions

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Elevation(
    val default: Dp = 0.dp,
    val thin: Dp = 1.dp,
    val extraSmall: Dp = 2.dp,
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 12.dp,
    val extraLarge: Dp = 16.dp,
)

val LocalElevation: ProvidableCompositionLocal<Elevation> = compositionLocalOf { Elevation() }

val MaterialTheme.elevation: Elevation
    @Composable
    @ReadOnlyComposable
    get() = LocalElevation.current