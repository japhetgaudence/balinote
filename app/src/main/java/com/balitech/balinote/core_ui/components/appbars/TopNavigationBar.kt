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
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.MoreVert
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
import androidx.compose.ui.draw.clip
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
import com.balitech.balinote.core_ui.theme.dimensions.spacing


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(
    scrollBehavior: TopAppBarScrollBehavior,
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
                ActionIcon(icon = Icons.Outlined.ViewAgenda, onClick = { /*TODO*/ })
                ActionIcon(icon = Icons.Outlined.FilterList, onClick = { /*TODO*/ })
                ActionIcon(icon = Icons.Outlined.MoreVert, onClick = { /*TODO*/ })
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = backgroundColor,
                scrolledContainerColor = backgroundColor
            ),
            scrollBehavior = scrollBehavior,
            modifier = Modifier.fillMaxWidth()
        )

        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.medium))

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
    }
}


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: Int = R.string.label_search,
    icon: ImageVector = Icons.Filled.Search,
    backgroundColor: Color = BottomAppBarDefaults.containerColor,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer.copy(0.65f),
    tonalElevation: Dp = BottomAppBarDefaults.ContainerElevation,
    shape: Shape = RoundedCornerShape(50),
    iconSize: Dp = 20.dp
) {
    Surface(
        color = backgroundColor,
        tonalElevation = tonalElevation,
        shape = shape,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.medium)
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar2(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.app_name),
    icon: ImageVector = Icons.Filled.Search,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
//    shape: Shape = MaterialTheme.shapes.small,
    shape: Shape = RoundedCornerShape(50),
    tonalElevation: Dp = BottomAppBarDefaults.ContainerElevation
) {
    Surface(
        shape = shape,
        color = backgroundColor,
        tonalElevation = tonalElevation,
        modifier = modifier.padding(horizontal = MaterialTheme.spacing.medium)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelLarge
                )
            },
            navigationIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = title
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                scrolledContainerColor = Color.Transparent
            ),
            scrollBehavior = scrollBehavior,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape)
        )
    }
}