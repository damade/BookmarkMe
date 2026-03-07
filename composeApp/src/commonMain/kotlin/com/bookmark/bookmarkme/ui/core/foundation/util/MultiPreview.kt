package com.bookmark.bookmarkme.ui.core.foundation.util

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(name = "Light", device = Devices.TABLET)
@Preview(name = "Dark", uiMode = 33, device = Devices.TABLET)
annotation class PreviewLightDarkTablet

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(name = "Light", device = Devices.PIXEL)
@Preview(name = "Dark", uiMode = 33, device = Devices.PIXEL)
annotation class PreviewLightDarkMobile

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(name = "Light", device = Devices.TABLET)
@Preview(name = "Dark", uiMode = 33, device = Devices.TABLET)
@Preview(name = "Light", device = Devices.PIXEL)
@Preview(name = "Dark", uiMode = 33, device = Devices.PIXEL)
annotation class PreviewLightDark
