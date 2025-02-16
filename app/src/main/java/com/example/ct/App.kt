package com.example.ct

import android.app.Application
import com.example.ct.data.sharedPrefs.SharedPrefs
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    companion object {
        lateinit var sharedPrefs: SharedPrefs
    }


    override fun onCreate() {
        super.onCreate()
        sharedPrefs = SharedPrefs(this)
        startKoin {
            modules(mainModule)
            androidContext(this@App)
        }
    }
}