package com.example.basektmvp2.utils
import android.annotation.SuppressLint
import android.widget.Toast

/**
 * Toast工具类
 */
object ToastUtils {

    private var TOAST: Toast? = null

    fun show(resourceID: Int) {
        show(resourceID, Toast.LENGTH_SHORT)
    }

    fun show(text: String) {
        show(text, Toast.LENGTH_SHORT)
    }

    fun show(resourceID: Int, duration: Int) {
        val text = ResUtils.getString(resourceID)
        show(text, duration)
    }

    @SuppressLint("ShowToast")
    fun show(text: String, duration: Int) {
        TOAST = if (TOAST == null) {
            Toast.makeText(ResUtils.getContext(), text, duration)
        } else {
            TOAST?.cancel()
            Toast.makeText(ResUtils.getContext(), text, duration)
        }
        TOAST?.show()
    }

}