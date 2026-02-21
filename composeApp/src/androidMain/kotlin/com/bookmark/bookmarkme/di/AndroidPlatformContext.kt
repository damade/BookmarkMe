package com.bookmark.bookmarkme.di

import android.content.Context
import com.bookmark.bookmarkme.di.platform.PlatformContext

class AndroidPlatformContext(
    val context: Context,
) : PlatformContext
