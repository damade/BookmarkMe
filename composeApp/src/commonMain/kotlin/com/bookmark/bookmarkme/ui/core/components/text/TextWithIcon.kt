package com.bookmark.bookmarkme.ui.core.components.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bookmark.bookmarkme.core.model.CallbackParam
import com.bookmark.bookmarkme.ui.core.components.modifiers.conditional
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkPreviewTheme

@Composable
fun TextWithIcon(
    text: String,
    modifier: Modifier = Modifier,
    leadingIcon: Painter? = null,
    onClickLeadingIcon: CallbackParam? = null,
    trailingIcon: Painter? = null,
    onClickTrailingIcon: CallbackParam? = null,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    textColor: Color = LocalContentColor.current,
    tint: Color = LocalContentColor.current,
    spaceSize: Dp = 8.dp,
    contentDescription: String? = null,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(space = spaceSize),
    ) {
        if (leadingIcon != null) {
            Icon(
                painter = leadingIcon,
                contentDescription = contentDescription,
                modifier =
                    Modifier.conditional(
                        checkNotNullValue = onClickLeadingIcon,
                        ifNotNull = { clickable(onClick = it) },
                    ),
                tint = tint,
            )
        }
        BookmarkText(
            text = text,
            style = textStyle,
            color = textColor,
            modifier = Modifier.weight(weight = 1F, fill = false),
        )
        if (trailingIcon != null) {
            Icon(
                painter = trailingIcon,
                contentDescription = contentDescription,
                modifier =
                    Modifier.conditional(
                        checkNotNullValue = onClickTrailingIcon,
                        ifNotNull = { clickable(onClick = it) },
                    ),
                tint = tint,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    BookmarkPreviewTheme {
        TextWithIcon(
            text = "Lorem ipsum sit amet what is going on here and more text to see if it pushed icon out of view",
            leadingIcon = rememberVectorPainter(image = Icons.Filled.Call),
            trailingIcon = rememberVectorPainter(image = Icons.Filled.Add),
        )
    }
}
