package com.bookmark.bookmarkme.di.platform

import com.bookmark.bookmarkme.core.model.AppEnvironment

interface AppInfoProvider {
    fun getAppVersionName(): String

    fun getAppVersionCode(): Int

    fun getAppName(): String

    fun getAppEnvironment(): AppEnvironment

    fun getDeviceOsVersion(): Int
}
