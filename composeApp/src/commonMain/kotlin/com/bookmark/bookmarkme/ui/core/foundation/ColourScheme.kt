package com.bookmark.bookmarkme.ui.core.foundation

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.expressiveLightColorScheme

val bookmarkDarkColourScheme =
    darkColorScheme(
        primary = DarkPalette.Blue,
        onPrimary = DarkPalette.Black,
        tertiary = DarkPalette.Orange,
        onTertiary = DarkPalette.Black,
        error = DarkPalette.Red,
        surface = DarkPalette.BackgroundPrimary,
        onSurface = DarkPalette.LabelPrimary,
        background = DarkPalette.BackgroundPrimary,
        onBackground = DarkPalette.LabelPrimary,
        secondaryContainer = DarkPalette.BackgroundSecondary,
        surfaceVariant = DarkPalette.BackgroundSecondary,
        onSurfaceVariant = DarkPalette.LabelSecondary,
        outline = DarkPalette.Blue,
        outlineVariant = DarkPalette.Gray5,
    )

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val bookmarkExpressiveLightColourScheme =
    expressiveLightColorScheme().copy(
        primary = LightPalette.Blue,
        onPrimary = LightPalette.White,
        tertiary = LightPalette.Orange,
        onTertiary = LightPalette.White,
        error = LightPalette.Red,
        surface = LightPalette.BackgroundPrimary,
        onSurface = LightPalette.LabelPrimary,
        background = LightPalette.BackgroundPrimary,
        onBackground = LightPalette.LabelPrimary,
        secondaryContainer = LightPalette.BackgroundSecondary,
        surfaceVariant = LightPalette.BackgroundSecondary,
        onSurfaceVariant = LightPalette.LabelSecondary,
        outline = LightPalette.Blue,
        outlineVariant = LightPalette.Gray5,
    )
