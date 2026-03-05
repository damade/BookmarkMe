package com.bookmark.bookmarkme.ui.core.foundation

import androidx.compose.ui.graphics.Color

/**
 * Raw color palette extracted from the design system.
 *
 * Use [LightPalette] and [DarkPalette] to reference raw colors.
 * For themed color usage, prefer [bookmarkDarkColourScheme] and
 * [bookmarkExpressiveLightColourScheme] via MaterialTheme.
 */
object LightPalette {
    // region Accents
    val Red = Color(0xFFFF383C)
    val Orange = Color(0xFFFF8D28)
    val Yellow = Color(0xFFFFCC00)
    val Green = Color(0xFF34C759)
    val Mint = Color(0xFF00C8B3)
    val Teal = Color(0xFF00C3D0)
    val Cyan = Color(0xFF00C0E8)
    val Blue = Color(0xFF0088FF)
    val Indigo = Color(0xFF6155F5)
    val Purple = Color(0xFFCB30E0)
    val Pink = Color(0xFFFF2D55)
    val Brown = Color(0xFFAC7F5E)
    // endregion

    // region Backgrounds
    val BackgroundPrimary = Color(0xFFFFFFFF)
    val BackgroundSecondary = Color(0xFFF2F2F7)
    val BackgroundTertiary = Color(0xFFFFFFFF)
    // endregion

    // region Backgrounds Grouped
    val BackgroundGroupedPrimary = Color(0xFFF2F2F7)
    val BackgroundGroupedSecondary = Color(0xFFFFFFFF)
    val BackgroundGroupedTertiary = Color(0xFFF2F2F7)
    // endregion

    // region Fills
    val FillPrimary = Color(0x33787878)
    val FillSecondary = Color(0x29787880)
    val FillTertiary = Color(0x1F767680)
    val FillQuaternary = Color(0x14747480)
    // endregion

    // region Grays
    val Gray = Color(0xFF8E8E93)
    val Gray2 = Color(0xFFAEAEB2)
    val Gray3 = Color(0xFFC7C7CC)
    val Gray4 = Color(0xFFD1D1D6)
    val Gray5 = Color(0xFFE5E5EA)
    val Gray6 = Color(0xFFF2F2F7)
    val Black = Color(0xFF000000)
    val White = Color(0xFFFFFFFF)
    // endregion

    // region Labels
    val LabelPrimary = Color(0xFF000000)
    val LabelSecondary = Color(0x993C3C43)
    val LabelTertiary = Color(0x4D3C3C43)
    val LabelQuaternary = Color(0x2E3C3C43)
    // endregion

    // region Separators
    val SeparatorOpaque = Color(0xFFC6C6C8)
    val SeparatorNonOpaque = Color(0x1F000000)
    // endregion

    // region Vibrant Fills
    val VibrantFillDarkPrimary = Color(0xFF333333)
    val VibrantFillDarkSecondary = Color(0xFF1F1F1F)
    val VibrantFillDarkTertiary = Color(0xFF121212)
    val VibrantFillLightPrimary = Color(0xFFCCCCCC)
    val VibrantFillLightSecondary = Color(0xFFE0E0E0)
    val VibrantFillLightTertiary = Color(0xFFEDEDED)
    // endregion

    // region Vibrant Labels
    val VibrantLabelDarkPrimary = Color(0xFFFFFFFF)
    val VibrantLabelDarkSecondary = Color(0xFF999999)
    val VibrantLabelDarkTertiary = Color(0xFF404040)
    val VibrantLabelDarkQuaternary = Color(0xFF262626)
    val VibrantLabelLightPrimary = Color(0xFF000000)
    val VibrantLabelLightSecondary = Color(0x807F7F7F)
    val VibrantLabelLightTertiary = Color(0x667F7F7F)
    val VibrantLabelLightQuaternary = Color(0x337F7F7F)
    // endregion
}

object DarkPalette {
    // region Accents
    val Red = Color(0xFFFF4245)
    val Orange = Color(0xFFFFA056)
    val Yellow = Color(0xFFFEDF43)
    val Green = Color(0xFF4AE968)
    val Mint = Color(0xFF54DFCB)
    val Teal = Color(0xFF3BDDEC)
    val Cyan = Color(0xFF6DD9FF)
    val Blue = Color(0xFF0091FF)
    val Indigo = Color(0xFFA7AAFF)
    val Purple = Color(0xFFEA8DFF)
    val Pink = Color(0xFFFF8AC4)
    val Brown = Color(0xFFDBA679)
    // endregion

    // region Backgrounds
    val BackgroundPrimary = Color(0xFF000000)
    val BackgroundSecondary = Color(0xFF242426)
    val BackgroundTertiary = Color(0xFF363638)
    val BackgroundPrimaryElevated = Color(0xFF242426)
    val BackgroundSecondaryElevated = Color(0xFF363638)
    val BackgroundTertiaryElevated = Color(0xFF3A3A3C)
    // endregion

    // region Backgrounds Grouped
    val BackgroundGroupedPrimary = Color(0xFF000000)
    val BackgroundGroupedSecondary = Color(0xFF242426)
    val BackgroundGroupedTertiary = Color(0xFF363638)
    val BackgroundGroupedPrimaryElevated = Color(0xFF242426)
    val BackgroundGroupedSecondaryElevated = Color(0xFF363638)
    val BackgroundGroupedTertiaryElevated = Color(0xFF3A3A3C)
    // endregion

    // region Fills
    val FillPrimary = Color(0x70787880)
    val FillSecondary = Color(0x66787880)
    val FillTertiary = Color(0x52767680)
    val FillQuaternary = Color(0x42767680)
    // endregion

    // region Grays
    val Gray = Color(0xFF8E8E93)
    val Gray2 = Color(0xFF636366)
    val Gray3 = Color(0xFF48484A)
    val Gray4 = Color(0xFF3A3A3C)
    val Gray5 = Color(0xFF2C2C2E)
    val Gray6 = Color(0xFF1C1C1E)
    val Black = Color(0xFF000000)
    val White = Color(0xFFFFFFFF)
    // endregion

    // region Labels
    val LabelPrimary = Color(0xFFFFFFFF)
    val LabelSecondary = Color(0x99EBEBF5)
    val LabelTertiary = Color(0x4DEBEBF5)
    val LabelQuaternary = Color(0x29EBEBF5)
    // endregion

    // region Separators
    val SeparatorOpaque = Color(0xFF38383A)
    val SeparatorNonOpaque = Color(0x2BFFFFFF)
    val SeparatorVibrant = Color(0xFF1A1A1A)
    // endregion
}
