package com.bookmark.bookmarkme.ui.core.components.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.takeOrElse

/**
 * Custom padding modifier that allows for the specification
 * of a variety of fields. Precedence of fields are as follows:
 * individual (e.g. top) > group (e.g. vertical) > remaining.
 */
@Stable
fun Modifier.padding(
    horizontal: Dp = Dp.Unspecified,
    vertical: Dp = Dp.Unspecified,
    top: Dp = Dp.Unspecified,
    bottom: Dp = Dp.Unspecified,
    start: Dp = Dp.Unspecified,
    end: Dp = Dp.Unspecified,
    remaining: Dp = Dp.Unspecified,
): Modifier {
    val startPadding =
        start.takeOrElse {
            horizontal.takeOrElse {
                remaining.takeOrElse {
                    0.dp
                }
            }
        }
    val endPadding =
        end.takeOrElse {
            horizontal.takeOrElse {
                remaining.takeOrElse {
                    0.dp
                }
            }
        }
    val topPadding =
        top.takeOrElse {
            vertical.takeOrElse {
                remaining.takeOrElse {
                    0.dp
                }
            }
        }
    val bottomPadding =
        bottom.takeOrElse {
            vertical.takeOrElse {
                remaining.takeOrElse {
                    0.dp
                }
            }
        }

    return this.padding(
        start = startPadding,
        end = endPadding,
        top = topPadding,
        bottom = bottomPadding,
    )
}
