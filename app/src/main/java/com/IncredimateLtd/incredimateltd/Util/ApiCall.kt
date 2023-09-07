package com.IncredimateLtd.incredimateltd.Util

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


fun <T : Any> callApiG(call: Call<T>, fxn: (res: Any, code:String, IsSuccess:Boolean) -> Unit) {
    if (NetworkUtil.isConnected()) {
        // showDialog()
        call.enqueue(object : Callback<T> {
            override fun onResponse(
                call: Call<T>,
                response: Response<T>
            ) {
                val res = response.body()
                log("", "response......." + res?.toString())
                if (response.isSuccessful && res != null) {
                    log("", "SUCCESS")
                    fxn(res,response.code().toString(),true)
                } else {
                    log("", "NULL")
                    if (response.message().toString().isNotEmpty())toast(response.message().toString())
                    else toast(response.code().toString())
                    fxn(call,response.code().toString(),false)
                }
            }
            override fun onFailure(call: Call<T>, t: Throwable) {
                log("TAG", t.message)
                fxn(call,"",false)
            }
        })
    }
}
