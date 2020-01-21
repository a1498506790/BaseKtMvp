package com.example.basektmvp2.utils
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import com.example.basektmvp2.base.App


/**
 * 网络状态工具类
 */
object NetStatusUtils {

    fun isNetworkConnected(): Boolean {
        val mConnectivityManager = App.context
            .getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val mNetworkInfo = mConnectivityManager.activeNetworkInfo
        if (mNetworkInfo != null) {
            return mNetworkInfo.isAvailable
        }
        return false
    }

}