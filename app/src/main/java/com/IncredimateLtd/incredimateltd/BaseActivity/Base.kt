package com.IncredimateLtd.incredimateltd.BaseActivity



import androidx.appcompat.app.AppCompatActivity
import com.IncredimateLtd.incredimateltd.Util.MyDialogBox
import com.IncredimateLtd.incredimateltd.Util.NetworkUtil
import com.IncredimateLtd.incredimateltd.Util.callApiG


open class BaseActivtiy : AppCompatActivity() {
    var dialogBox: MyDialogBox? = null
    var c = this@BaseActivtiy


    fun <T : Any> callApi(call: retrofit2.Call<T>, showDialog: Boolean = true, fxn: (res: Any) -> Unit) {
        if (NetworkUtil.isConnected()) {
            if (showDialog) showDialog()
            callApiG(call) { res, code, isSucces ->
                if (isSucces) fxn(res)
                else {
                    if (code == "401") {
//                        callApi(RetrofitClient().refreshToken()) {
//                            if (it is LoginResponse) {
//                                if (!it.error) {
//                                    it.data?.let { SharedPref.setUSERTOKEN(it) }
//                                }
//                            }
//                        }
                    }
                }
                dismissDialog()
            }
        }
    }

    fun showDialog() {
        dialogBox?.run {
            if (!this.isShowing) show()
        } ?: run {
            dialogBox = MyDialogBox(c)
            dialogBox?.show()
        }
    }

    fun dismissDialog() {
        dialogBox?.run {
            if (this.isShowing) dismiss()
        } ?: run {
            dialogBox = MyDialogBox(c)
        }
    }

}