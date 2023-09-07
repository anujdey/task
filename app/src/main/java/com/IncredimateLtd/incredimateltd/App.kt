package com.IncredimateLtd.incredimateltd

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context


class
App : Application() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var appCtx: Context
        var isFromOrder= false

        var singleton:App? = null
        var isAppRunning = false
        var isAppInForeground = false
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate() {
        super.onCreate()
        appCtx =applicationContext
        init()
    }


    @SuppressLint("SuspiciousIndentation")
    private fun init() {
        if (singleton == null)
            singleton = this
        isAppRunning = true
    }
}