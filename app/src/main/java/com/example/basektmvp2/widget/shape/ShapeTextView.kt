package com.example.basektmvp2.widget.shape

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.basektmvp2.R

class ShapeTextView : AppCompatTextView {

    private lateinit var stateListDrawable: StateListDrawable
    private lateinit var normalDrawable: GradientDrawable
    private lateinit var pressedDrawable: GradientDrawable

    var shape = 0
    var normalColor = 0
    var pressedColor = 0
    var cornerRadius = 0
    var cornerTopLeftRadius = 0
    var cornerTopRightRadius = 0
    var cornerBottomLeftRadius = 0
    var cornerBottomRightRadius = 0
    var strokeWidth = 0
    var strokeColor = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        val obtainStyledAttributes =
            context.obtainStyledAttributes(attributeSet, R.styleable.ShapeTextView)
        shape = obtainStyledAttributes.getInt(R.styleable.ShapeTextView_stvShape, shape)
        normalColor =
            obtainStyledAttributes.getColor(R.styleable.ShapeTextView_stvNormalColor, normalColor)
        pressedColor =
            obtainStyledAttributes.getColor(R.styleable.ShapeTextView_stvPressedColor, pressedColor)
        cornerRadius = obtainStyledAttributes.getDimensionPixelOffset(
            R.styleable.ShapeTextView_stvCornerRadius,
            cornerRadius
        )
        cornerTopLeftRadius = obtainStyledAttributes.getDimensionPixelOffset(
            R.styleable.ShapeTextView_stvCornerTopLeftRadius,
            cornerTopLeftRadius
        )
        cornerBottomLeftRadius = obtainStyledAttributes.getDimensionPixelOffset(
            R.styleable.ShapeTextView_stvCornerBottomLeftRadius,
            cornerBottomLeftRadius
        )
        cornerTopRightRadius = obtainStyledAttributes.getDimensionPixelOffset(
            R.styleable.ShapeTextView_stvCornerTopRightRadius,
            cornerTopRightRadius
        )
        cornerBottomRightRadius = obtainStyledAttributes.getDimensionPixelOffset(
            R.styleable.ShapeTextView_stvCornerBottomRightRadius,
            cornerBottomRightRadius
        )
        strokeWidth = obtainStyledAttributes.getDimensionPixelOffset(
            R.styleable.ShapeTextView_stvStrokeWidth,
            strokeWidth
        )
        strokeColor =
            obtainStyledAttributes.getColor(R.styleable.ShapeTextView_stvStrokeColor, strokeColor)
        obtainStyledAttributes.recycle()
        init()
    }

    private fun init() {
        build()
    }

    fun setShape(shape: Int): ShapeTextView {
        this.shape = shape
        this.shape = shape
        return this
    }

    fun setNormalColor(normalColor: Int): ShapeTextView {
        this.normalColor = normalColor
        return this
    }

    fun setPressedColor(pressedColor: Int): ShapeTextView {
        this.pressedColor = pressedColor
        return this
    }

    fun setCornerRadius(cornerRadius: Int): ShapeTextView {
        this.cornerRadius = cornerRadius
        return this
    }

    fun setCornerTopLeftRadius(cornerTopLeftRadius: Int): ShapeTextView {
        this.cornerTopLeftRadius = cornerTopLeftRadius
        return this
    }

    fun setCornerTopRightRadius(cornerTopRightRadius: Int): ShapeTextView {
        this.cornerTopRightRadius = cornerTopRightRadius
        return this
    }

    fun setCornerBottomLeftRadius(cornerBottomLeftRadius: Int): ShapeTextView {
        this.cornerBottomLeftRadius = cornerBottomLeftRadius
        return this
    }

    fun setCornerBottomRightRadius(cornerBottomRightRadius: Int): ShapeTextView {
        this.cornerBottomRightRadius = cornerBottomRightRadius
        return this
    }

    fun setStrokeWidthColor(strokeWidth: Int, strokeColor: Int): ShapeTextView {
        this.strokeWidth = strokeWidth
        this.strokeColor = strokeColor
        return this
    }

    fun setStrokeWidth(strokeWidth: Int): ShapeTextView {
        this.strokeWidth = strokeWidth
        return this
    }

    fun setStrokeColor(strokeColor: Int): ShapeTextView {
        this.strokeColor = strokeColor
        return this
    }

    fun build() {
        stateListDrawable = StateListDrawable()
        normalDrawable = GradientDrawable()
        pressedDrawable = GradientDrawable()
        normalDrawable.shape = shape
        pressedDrawable.shape = shape
        normalDrawable.setColor(normalColor)
        pressedDrawable.setColor(pressedColor)
        if (shape != GradientDrawable.OVAL) {
            if (cornerRadius > 0) {
                normalDrawable.cornerRadius = cornerRadius.toFloat()
                pressedDrawable.cornerRadius = cornerRadius.toFloat()
            } else {
                normalDrawable.cornerRadii = floatArrayOf(
                    cornerTopLeftRadius.toFloat(), cornerTopLeftRadius.toFloat(),
                    cornerTopRightRadius.toFloat(), cornerTopRightRadius.toFloat(),
                    cornerBottomRightRadius.toFloat(), cornerBottomRightRadius.toFloat(),
                    cornerBottomLeftRadius.toFloat(), cornerBottomLeftRadius.toFloat()
                )
                pressedDrawable.cornerRadii = floatArrayOf(
                    cornerTopLeftRadius.toFloat(), cornerTopLeftRadius.toFloat(),
                    cornerTopRightRadius.toFloat(), cornerTopRightRadius.toFloat(),
                    cornerBottomRightRadius.toFloat(), cornerBottomRightRadius.toFloat(),
                    cornerBottomLeftRadius.toFloat(), cornerBottomLeftRadius.toFloat()
                )
            }
        }
        normalDrawable.setStroke(strokeWidth, strokeColor)
        pressedDrawable.setStroke(strokeWidth, strokeColor)
        stateListDrawable.addState(intArrayOf(android.R.attr.state_pressed), pressedDrawable)
        stateListDrawable.addState(intArrayOf(), normalDrawable)
        background = stateListDrawable
    }

}