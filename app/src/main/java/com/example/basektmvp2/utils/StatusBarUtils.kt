package com.example.basektmvp2.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import com.example.basektmvp2.base.App

class StatusBarUtils {

    companion object {

        fun setTranslucentStatus(activity: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = activity.window
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                activity.window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                )
            }
        }

        fun isTranslucentStatus(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
        }

        fun getStatusBarHeight(): Int {
            val resources = App.getContext()?.resources
            resources?.let {
                val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
                return resources.getDimensionPixelSize(resourceId)
            }
            return 0
        }

        /**
         * 设置状态栏模式 暗色还是亮色
         */
        fun setStatusBarMode(activity: Activity, isDark: Boolean): Boolean {
            if (isTranslucentStatus()) {
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    val decorView = activity.window.decorView
                    if (isDark) {
                        decorView.systemUiVisibility =
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    } else {
                        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    }
                    true
                } else {
                    if (setFlyMeStatusBarMode(activity, isDark)) {
                        true
                    } else
                        setMiUiStatusBarMode(activity, isDark)
                }
            }
            return false
        }

        private fun setFlyMeStatusBarMode(activity: Activity, isDark: Boolean): Boolean {
            var result = false
            val window = activity.window
            if (window != null) {
                try {
                    val lp = window.attributes
                    val darkFlag = WindowManager.LayoutParams::class.java
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON")
                    val meizuFlags = WindowManager.LayoutParams::class.java
                        .getDeclaredField("meizuFlags")
                    darkFlag.isAccessible = true
                    meizuFlags.isAccessible = true
                    val bit = darkFlag.getInt(null)
                    var value = meizuFlags.getInt(lp)
                    if (isDark) {
                        value = value or bit
                    } else {
                        value = value and bit.inv()
                    }
                    meizuFlags.setInt(lp, value)
                    window.attributes = lp
                    result = true
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
            return result
        }

        @SuppressLint("PrivateApi")
        private fun setMiUiStatusBarMode(activity: Activity, dark: Boolean): Boolean {
            var result = false
            val window = activity.window
            if (window != null) {
                val clazz = window.javaClass
                try {
                    var darkModeFlag = 0
                    val layoutParams = Class.forName("android.view.MiuiWindowManager\$LayoutParams")
                    val field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
                    darkModeFlag = field.getInt(layoutParams)
                    val extraFlagField = clazz.getMethod(
                        "setExtraFlags",
                        Int::class.javaPrimitiveType,
                        Int::class.javaPrimitiveType
                    )
                    if (dark) {
                        extraFlagField.invoke(window, darkModeFlag, darkModeFlag)//状态栏透明且黑色字体
                    } else {
                        extraFlagField.invoke(window, 0, darkModeFlag)//清除黑色字体
                    }
                    result = true
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
            return result
        }

    }

}