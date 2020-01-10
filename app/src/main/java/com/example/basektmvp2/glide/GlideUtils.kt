package com.example.basektmvp2.glide

import android.graphics.drawable.GradientDrawable
import android.widget.ImageView
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.basektmvp2.R
import com.example.basektmvp2.utils.ResUtils

/**
 * 图片加载框架
 */
object GlideUtils {

    fun loadHeadIcon(imageView: ImageView, url: String){
        val circleCrop = CircleCrop()
        GlideApp.with(imageView)
            .load(url)
            .transform(MultiTransformation(circleCrop, circleCrop))
            .placeholder(R.drawable.glide_default_head_icon)
            .error(R.drawable.glide_default_head_icon)
            .into(imageView)
    }

    fun loadRound(imageView: ImageView, url: String, rounded : Int){
        val gradientDrawable = GradientDrawable()
        gradientDrawable.cornerRadius = rounded.toFloat()
        gradientDrawable.setColor(ResUtils.getColor(R.color.color9))
        GlideApp.with(imageView)
            .load(url)
            .transform(MultiTransformation(CenterCrop(), RoundedCorners(rounded)))
            .placeholder(gradientDrawable)
            .error(gradientDrawable)
            .into(imageView)
    }

    fun load(imageView: ImageView, url: String){
        GlideApp.with(imageView)
            .load(url)
            .placeholder(R.drawable.glide_default_placeholder)
            .error(R.drawable.glide_default_error)
            .centerCrop()
            .into(imageView)
    }

}