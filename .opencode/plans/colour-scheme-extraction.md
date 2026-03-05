# Colour Scheme Extraction Plan

## Goal
Extract the TS color palette into Compose Color constants and wire them into Material3 `darkColorScheme` and `expressiveLightColorScheme` for the KMP project.

## Files to Create/Modify

### 1. CREATE: `BookmarkPalette.kt`
**Path:** `composeApp/src/commonMain/kotlin/com/bookmark/bookmarkme/ui/core/foundation/BookmarkPalette.kt`

Contains two objects (`LightPalette`, `DarkPalette`) with all raw `Color` constants from the TS file, organized by category (accents, backgrounds, backgroundsGrouped, fills, grays, labels, separators, vibrantFills, vibrantLabels).

### 2. MODIFY: `ColourScheme.kt`
**Path:** `composeApp/src/commonMain/kotlin/com/bookmark/bookmarkme/ui/core/foundation/ColourScheme.kt`

Replace the empty stub with:
- `bookmarkDarkColourScheme` using `darkColorScheme(...)` with M3 roles mapped from `DarkPalette`
- `bookmarkExpressiveLightColourScheme` using `expressiveLightColorScheme(...)` with M3 roles mapped from `LightPalette`

**M3 Role Mapping (from docs + inferred):**

| M3 Role           | Light Source               | Dark Source               |
|--------------------|----------------------------|---------------------------|
| primary            | LightPalette.Blue          | DarkPalette.Blue          |
| onPrimary          | LightPalette.White         | DarkPalette.Black         |
| tertiary           | LightPalette.Orange        | DarkPalette.Orange        |
| onTertiary         | LightPalette.White         | DarkPalette.Black         |
| error              | LightPalette.Red           | DarkPalette.Red           |
| surface            | LightPalette.BackgroundPrimary | DarkPalette.BackgroundPrimary |
| onSurface          | LightPalette.LabelPrimary  | DarkPalette.LabelPrimary  |
| background         | LightPalette.BackgroundPrimary | DarkPalette.BackgroundPrimary |
| onBackground       | LightPalette.LabelPrimary  | DarkPalette.LabelPrimary  |
| secondaryContainer | LightPalette.BackgroundSecondary | DarkPalette.BackgroundSecondary |
| surfaceVariant     | LightPalette.BackgroundSecondary | DarkPalette.BackgroundSecondary |
| onSurfaceVariant   | LightPalette.LabelSecondary | DarkPalette.LabelSecondary |
| outline            | LightPalette.Blue          | DarkPalette.Blue          |
| outlineVariant     | LightPalette.Gray5         | DarkPalette.Gray5         |

### 3. MODIFY: `BookmarkTheme.android.kt`
**Path:** `composeApp/src/androidMain/kotlin/com/bookmark/bookmarkme/ui/core/foundation/BookmarkTheme.android.kt`

Replace non-dynamic fallback:
- `isDarkTheme -> bookmarkDarkColourScheme`
- `else -> bookmarkExpressiveLightColourScheme`

Remove now-unused imports: `darkColorScheme`, `expressiveLightColorScheme`, `Color`.

### 4. MODIFY: `BookmarkTheme.desktop.kt`
**Path:** `composeApp/src/jvmMain/kotlin/com/bookmark/bookmarkme/ui/core/foundation/BookmarkTheme.desktop.kt`

Same changes as android. Replace inline schemes with `bookmarkDarkColourScheme` and `bookmarkExpressiveLightColourScheme`.

Remove now-unused imports: `darkColorScheme`, `expressiveLightColorScheme`, `Color`.

### 5. BUILD VERIFICATION
Run the build to confirm everything compiles.

## Status: COMPLETED
