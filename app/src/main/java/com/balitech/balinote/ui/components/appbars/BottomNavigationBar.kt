package com.balitech.balinote.ui.components.appbars

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.balitech.balinote.ui.navigation.BottomNavItem


@Composable
fun BottomNavigationBar(
    selectedItem: BottomNavItem,
    onItemClick: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier,
    navItems: Set<BottomNavItem> = BottomNavItem.getItems(),
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
    tonalElevation: Dp = NavigationBarDefaults.Elevation,
    showLabels: Boolean = true
) {
    NavigationBar(
        modifier = modifier,
        tonalElevation = tonalElevation,
        windowInsets = windowInsets
    ) {
        navItems.forEach { item: BottomNavItem ->
            val selected = item == selectedItem

            NavigationBarItem(
                selected = selected,
                alwaysShowLabel = showLabels,
                onClick = { onItemClick(item) },
                icon = { BottomNavIcon(item = item, selected = selected) },
                label = { BottomNavLabel(label = item.label, selected = selected) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.inversePrimary
                )
            )
        }
    }
}


@Composable
private fun BottomNavIcon(
    item: BottomNavItem,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Icon(
        modifier = modifier,
        contentDescription = stringResource(id = item.label),
        imageVector = if (selected) item.selectedIcon else item.unselectedIcon
    )
}


@Composable
private fun BottomNavLabel(
    @StringRes label: Int,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = label),
        style = MaterialTheme.typography.labelMedium,
        fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
        modifier = modifier
    )
}