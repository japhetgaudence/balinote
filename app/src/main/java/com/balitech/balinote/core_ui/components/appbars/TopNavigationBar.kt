package com.balitech.balinote.core_ui.components.appbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.balitech.balinote.R
import com.balitech.balinote.core_ui.components.icons.ActionIcon
import com.balitech.balinote.core_ui.types.ViewMode


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(
    viewMode: ViewMode,
    scrollBehavior: TopAppBarScrollBehavior,
    onToggleViewClick: () -> Unit,
    onSearchIconClick: () -> Unit,
    onNotificationIconClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.app_name),
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
) {
    TopAppBar(
        title = { TopNavBarTitle(title = title) },
        actions = {
            when(viewMode) {
                ViewMode.Grid -> ActionIcon(icon = viewMode.icon, onClick = onToggleViewClick)
                ViewMode.List -> ActionIcon(icon = viewMode.icon, onClick = onToggleViewClick)
            }

            ActionIcon(
                icon = Icons.Outlined.Notifications,
                onClick = onNotificationIconClick,
            )
            ActionIcon(
                icon = Icons.Outlined.Search,
                onClick = onSearchIconClick,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
            scrolledContainerColor = backgroundColor
        ),
        scrollBehavior = scrollBehavior,
        modifier = modifier
    )
}


@Composable
private fun TopNavBarTitle(
    title: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.headlineSmall,
    color: Color = MaterialTheme.colorScheme.onBackground,
) {
    Text(
        text = title,
        color = color,
        style = style,
        modifier = modifier
    )
}