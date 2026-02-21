package com.bookmark.bookmarkme.di

import android.os.Build
import com.bookmark.bookmarkme.BuildConfig
import com.bookmark.bookmarkme.core.model.AppEnvironment
import com.bookmark.bookmarkme.core.utils.APP_NAME
import com.bookmark.bookmarkme.di.platform.AppInfoProvider

class AndroidAppInfoProvider : AppInfoProvider {
    override fun getAppVersionName(): String = BuildConfig.VERSION_NAME

    override fun getAppVersionCode(): Int = BuildConfig.VERSION_CODE

    override fun getAppName(): String = APP_NAME

    override fun getAppEnvironment(): AppEnvironment = if (BuildConfig.DEBUG) AppEnvironment.Staging else AppEnvironment.Production

    override fun getDeviceOsVersion(): Int = Build.VERSION.SDK_INT
}
