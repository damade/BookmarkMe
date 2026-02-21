package com.bookmark.bookmarkme.di

import com.bookmark.bookmarkme.DesktopBuildConfig
import com.bookmark.bookmarkme.core.model.AppEnvironment
import com.bookmark.bookmarkme.di.platform.AppInfoProvider

class DesktopAppInfoProvider : AppInfoProvider {
    override fun getAppVersionName(): String = DesktopBuildConfig.VERSION_NAME

    override fun getAppVersionCode(): Int = DesktopBuildConfig.VERSION_CODE

    override fun getAppName(): String = DesktopBuildConfig.APP_NAME

    override fun getAppEnvironment(): AppEnvironment {
        val isDebug =
            System.getProperty("app.debug")?.toBoolean()
                ?: java.lang.management.ManagementFactory
                    .getRuntimeMXBean()
                    .inputArguments
                    .any { it.contains("-agentlib:jdwp") }
        return if (isDebug) AppEnvironment.Staging else AppEnvironment.Production
    }

    override fun getDeviceOsVersion(): Int {
        val osVersion = System.getProperty("os.version") ?: return 0
        // Extract major version number (e.g., "14.2.1" -> 14, "6.5.0-14-generic" -> 6, "10.0" -> 10)
        return osVersion.split(".", "-").firstOrNull()?.toIntOrNull() ?: 0
    }
}
