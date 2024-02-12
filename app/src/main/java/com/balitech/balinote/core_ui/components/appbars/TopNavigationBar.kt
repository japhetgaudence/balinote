package com.balitech.balinote.core_ui.components.appbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ViewAgenda
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.balitech.balinote.R
import com.balitech.balinote.core_ui.components.icons.ActionIcon
import com.balitech.balinote.core_ui.navigation.TopNavBarAction
import com.balitech.balinote.core_ui.theme.dimensions.elevation
import com.balitech.balinote.core_ui.theme.dimensions.spacing


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onActionClick: (TopNavBarAction) -> Unit,
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.app_name),
    backgroundColor: Color = Color.Transparent
) {
    Column(modifier = modifier) {
        TopAppBar(
            title = {
                TopNavBarTitle(title = title)
            },
            actions = {
                ActionIcon(
                    icon = Icons.Outlined.Notifications,
                    onClick = { onActionClick(TopNavBarAction.NavigateToRemindersScreen) }
                )
                ActionIcon(
                    icon = Icons.Outlined.MoreVert,
                    onClick = { onActionClick(TopNavBarAction.ToggleContextMenu) }
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = backgroundColor,
                scrolledContainerColor = backgroundColor
            ),
            scrollBehavior = scrollBehavior,
            modifier = Modifier.fillMaxWidth()
        )

        SearchBar(
            onClick = { onActionClick(TopNavBarAction.NavigateToSearchScreen) },
            onToggleLayout = { onActionClick(TopNavBarAction.ToggleLayout) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.medium),
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
    }
}


@Composable
fun SearchBar(
    onClick: () -> Unit,
    onToggleLayout: () -> Unit,
    modifier: Modifier = Modifier,
    hint: Int = R.string.label_search,
    icon: ImageVector = Icons.Filled.Search,
    backgroundColor: Color = BottomAppBarDefaults.containerColor,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer.copy(0.65f),
    tonalElevation: Dp = MaterialTheme.elevation.medium,
    shape: Shape = RoundedCornerShape(50),
    iconSize: Dp = 20.dp
) {
    Surface(
        onClick = onClick,
        color = backgroundColor,
        tonalElevation = tonalElevation,
        shape = shape,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.medium)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = stringResource(id = hint),
                    tint = contentColor,
                    modifier = Modifier.size(iconSize)
                )
                Text(
                    text = stringResource(id = hint),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = contentColor
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically,) {
                ActionIcon(
                    onClick = onToggleLayout,
                    icon = Icons.Outlined.ViewAgenda,
                    size = 18.dp
                )
            }
        }
    }
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