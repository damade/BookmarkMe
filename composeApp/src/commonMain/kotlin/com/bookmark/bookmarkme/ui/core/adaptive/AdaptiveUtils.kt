package com.bookmark.bookmarkme.ui.core.adaptive

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import com.bookmark.bookmarkme.ui.model.DeviceClass

val BoxWithConstraintsScope.isTabletScreenSize: Boolean
    get() = maxWidth >= TABLET_SCREEN_MIN_WIDTH

private val TABLET_SCREEN_MIN_WIDTH = 600.dp

private fun getScreenDeviceClass(windowSizeClass: WindowSizeClass): DeviceClass =
    when {
        windowSizeClass.isWidthAtLeastBreakpoint(
            widthDpBreakpoint = WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND,
        ) -> DeviceClass.DESKTOP

        windowSizeClass.isWidthAtLeastBreakpoint(
            widthDpBreakpoint = WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND,
        ) -> DeviceClass.TABLET

        else -> {
            DeviceClass.MOBILE
        }
    }

@Composable
fun rememberDeviceClass(): DeviceClass {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    return getScreenDeviceClass(windowSizeClass)
}
