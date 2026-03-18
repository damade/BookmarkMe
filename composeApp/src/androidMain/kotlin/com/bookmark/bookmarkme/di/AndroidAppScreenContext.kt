package com.bookmark.bookmarkme.di

import android.app.Activity
import com.bookmark.bookmarkme.di.platform.AppScreenContext

class AndroidAppScreenContext(
    val activity: Activity,
) : AppScreenContext
