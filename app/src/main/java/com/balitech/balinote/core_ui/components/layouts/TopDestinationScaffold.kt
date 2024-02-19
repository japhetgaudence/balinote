package com.balitech.balinote.core_ui.components.layouts

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import com.balitech.balinote.core_ui.components.appbars.TopNavigationBar
import com.balitech.balinote.core_ui.theme.dimensions.sizing
import com.balitech.balinote.core_ui.types.ViewMode


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopDestinationScaffold(
    @StringRes title: Int,
    viewMode: ViewMode,
    scrollBehavior: TopAppBarScrollBehavior,
    onToggleViewClick: () -> Unit,
    onSearchIconClick: () -> Unit,
    onNotificationIconClick: () -> Unit,
    tabsContent: @Composable () -> Unit,
    bodyContent: @Composable () -> Unit,
) {
    Scaffold(
        topBar = {
            Column {
                TopNavigationBar(
                    title = stringResource(id = title),
                    scrollBehavior = scrollBehavior,
                    viewMode = viewMode,
                    onToggleViewClick = onToggleViewClick,
                    onSearchIconClick = onSearchIconClick,
                    onNotificationIconClick = onNotificationIconClick
                )
                tabsContent()
            }
        },
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = MaterialTheme.sizing.bottomBarSize)
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding: PaddingValues ->
        val topPadding = innerPadding.calculateTopPadding()
        val bottomPadding = innerPadding.calculateBottomPadding()

        Surface(modifier = Modifier.padding(top = topPadding, bottom = bottomPadding)) {
            bodyContent()
        }
    }
}