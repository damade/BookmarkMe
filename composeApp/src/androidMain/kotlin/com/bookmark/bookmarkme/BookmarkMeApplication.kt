package com.bookmark.bookmarkme

import android.app.Application
import com.bookmark.bookmarkme.di.initKoin
import com.bookmark.bookmarkme.di.platformModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class BookmarkMeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin(
            platformModule
        ) {
            androidContext(androidContext = this@BookmarkMeApplication)
            androidLogger()
        }
    }
}
