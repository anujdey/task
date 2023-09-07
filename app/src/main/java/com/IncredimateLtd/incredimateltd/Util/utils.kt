package com.IncredimateLtd.incredimateltd.Util

import android.util.Log
import android.widget.Toast
import com.IncredimateLtd.incredimateltd.App.Companion.appCtx

fun toast(msg: String?) {
    Toast.makeText(
        appCtx, "" + msg,
        Toast.LENGTH_SHORT
    ).show()
}

fun log(tag: String? = "TAG", msg: String? = "Log here") {
    Log.d(tag, msg.toString())
}