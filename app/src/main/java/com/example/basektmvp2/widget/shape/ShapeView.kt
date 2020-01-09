package com.example.basektmvp2.widget.shape

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.graphics.drawable.StateListDrawable
import android.view.View
import android.graphics.drawable.GradientDrawable


class ShapeView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        val pressedDrawable = GradientDrawable()
        pressedDrawable.setColor(Color.RED)
        pressedDrawable.cornerRadius = 20f
        val normalDrawable = GradientDrawable()
        normalDrawable.setColor(Color.BLUE)
        normalDrawable.cornerRadius = 20f
        val drawable = StateListDrawable()
        drawable.addState(intArrayOf(android.R.attr.state_pressed), pressedDrawable)
        drawable.addState(intArrayOf(), normalDrawable)
        background = drawable
    }

}