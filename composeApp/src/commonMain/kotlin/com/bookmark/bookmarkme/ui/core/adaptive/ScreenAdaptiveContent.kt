package com.bookmark.bookmarkme.ui.core.adaptive

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bookmark.bookmarkme.ui.core.components.ComposableParam
import com.bookmark.bookmarkme.ui.model.DeviceClass

@Composable
fun ScreenAdaptiveContent(
    mobileContent: ComposableParam,
    desktopAndTabletContent: ComposableParam? = null,
    deviceClass: DeviceClass = rememberDeviceClass(),
) {
    val content =
        when (deviceClass) {
            DeviceClass.TABLET, DeviceClass.DESKTOP -> desktopAndTabletContent
            DeviceClass.MOBILE -> mobileContent
        }
    Box {
        content?.invoke() ?: mobileContent.invoke()
    }
}

@Composable
fun IndividualAdaptiveContent(
    mobileContent: ComposableParam,
    desktopAndTabletContent: ComposableParam,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(modifier = modifier) {
        if (isTabletScreenSize) {
            desktopAndTabletContent.invoke()
        } else {
            mobileContent.invoke()
        }
    }
}
