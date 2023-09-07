package com.IncredimateLtd.incredimateltd.Util

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import com.IncredimateLtd.incredimateltd.R


class MyDialogBox(context: Context) : Dialog(context) {

    constructor(context: Context, cancelable: Boolean) : this(context) {
        setCancelable(cancelable)
        setCanceledOnTouchOutside(cancelable)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  window.setBackgroundDrawableResource(R.color.trans)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_progress)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)
    }
}