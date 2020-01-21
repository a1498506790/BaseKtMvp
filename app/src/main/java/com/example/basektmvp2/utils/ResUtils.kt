package com.example.basektmvp2.utils

import android.content.res.Resources
import androidx.annotation.*
import androidx.core.content.ContextCompat
import com.example.basektmvp2.base.App

/**
 * 获取资源工具类
 */
object ResUtils {

    fun getContext() = App.context

    fun getResources() = getContext().resources

    fun getString(@StringRes resId: Int) = getResources().getString(resId)

    fun getColor(@ColorRes resId: Int) = ContextCompat.getColor(getContext(), resId)

    fun getDimens(@DimenRes resId: Int) = getResources().getDimensionPixelOffset(resId)

    fun getDrawable(@DrawableRes resId : Int) = ContextCompat.getDrawable(getContext(), resId)

    fun getStringArray(@ArrayRes resId: Int) = getResources().getStringArray(resId)

}