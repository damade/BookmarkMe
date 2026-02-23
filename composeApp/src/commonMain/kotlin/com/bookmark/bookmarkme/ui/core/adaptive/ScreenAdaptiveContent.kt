package com.bookmark.bookmarkme.ui.core.adaptive

import androidx.compose.runtime.Composable
import com.bookmark.bookmarkme.ui.core.components.ComposableParam


@Composable
fun ScreenAdaptiveContent(
    mobileContent: ComposableParam,
    tabletContent: ComposableParam? = null,
    desktopContent: ComposableParam? = null,
) {
    when (ScreenAdaptiveState.current.screenType.deviceClass) {
        DeviceClass.MOBILE -> mobileContent()
        DeviceClass.TABLET -> tabletContent?.invoke() ?: mobileContent()
        DeviceClass.DESKTOP -> desktopContent?.invoke() ?: tabletContent?.invoke() ?: mobileContent()
    }
}
