package com.bookmark.bookmarkme.ui.core.components.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bookmark.bookmarkme.ui.core.components.ComposableParam

@Composable
fun BookmarkScaffold(
    modifier: Modifier = Modifier,
    topBar: ComposableParam = {},
    bottomBar: ComposableParam = {},
    content: ComposableParam,
) {
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        bottomBar = bottomBar,
        content = { innerPadding ->
            Box(modifier = Modifier.padding(paddingValues = innerPadding)) {
                content()
            }
        },
    )
}

@Composable
fun BookmarkScaffold(
    modifier: Modifier = Modifier,
    topBar: ComposableParam = {},
    bottomBar: ComposableParam = {},
    mobileContent: ComposableParam,
    tabletContent: ComposableParam? = null,
    desktopContent: ComposableParam? = null,
) {
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        bottomBar = bottomBar,
        content = { innerPadding ->
            Box(modifier = Modifier.padding(paddingValues = innerPadding)) {
                when (getCurrentDeviceClass()) {
                    DeviceClass.MOBILE -> mobileContent?.invoke()
                    DeviceClass.TABLET -> tabletContent?.invoke()
                    DeviceClass.DESKTOP -> desktopContent?.invoke()

                    else -> {
                        // Fallback to mobile content if device class is unknown
                        mobileContent?.invoke()
                    }
                }
            }
        },
    )
}
