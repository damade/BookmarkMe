package com.bookmark.bookmarkme

import android.app.Application
import com.bookmark.bookmarkme.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class BookmarkMeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(androidContext = this@BookmarkMeApplication)
            androidLogger()
        }
    }
}
