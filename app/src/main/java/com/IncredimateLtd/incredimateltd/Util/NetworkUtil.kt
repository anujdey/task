package com.IncredimateLtd.incredimateltd.Util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.IncredimateLtd.incredimateltd.App.Companion.appCtx


object NetworkUtil {

    private val TYPE_CONNECTED = 1
    private val TYPE_NOT_CONNECTED = 0


    private fun getConnectivityStatus(): Int {
        val cm = appCtx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        var activeNetwork: NetworkInfo? = null
        activeNetwork = cm.activeNetworkInfo
        activeNetwork?.let {
            if (it.isConnected)
                return TYPE_CONNECTED

        }


        return TYPE_NOT_CONNECTED
    }

    fun isConnected(): Boolean {
        val conn = getConnectivityStatus()
        var status = false
        if (conn == TYPE_CONNECTED) {
            status = true
        } else if (conn == TYPE_NOT_CONNECTED) {
            toast( "No Internet connection")
            status = false
        }
        return status
    }



}
