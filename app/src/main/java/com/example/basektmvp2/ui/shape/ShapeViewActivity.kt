package com.example.basektmvp2.ui.shape

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.SeekBar
import com.example.basektmvp2.base.BaseActivity
import kotlinx.android.synthetic.main.activity_select_text_view.*
import top.defaults.colorpicker.ColorPickerPopup
import android.graphics.Color
import com.example.basektmvp2.R


class ShapeViewActivity : BaseActivity(){

    override fun getLayoutId() = R.layout.activity_select_text_view

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initToolbar("代码写shapeView")
        shapeView.setOnClickListener {}
        sbRadius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                shapeView.setCornerRadius(shapeView.width / 2 * progress / 100)
                    .build()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        sbTopLeftRadius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                shapeView.setCornerTopLeftRadius(shapeView.width / 2 * progress / 100)
                    .build()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        sbTopRightRadius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                shapeView.setCornerTopRightRadius(shapeView.width / 2 * progress / 100)
                    .build()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        sbBottomLeftRadius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                shapeView.setCornerBottomLeftRadius(shapeView.width / 2 * progress / 100)
                    .build()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        sbBottomLeftRadius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                shapeView.setCornerBottomLeftRadius(shapeView.width / 2 * progress / 100)
                    .build()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        sbBottomRightRadius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                shapeView.setCornerBottomRightRadius(shapeView.width / 2 * progress / 100)
                    .build()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        swShape.setOnCheckedChangeListener { _, isChecked ->
            shapeView.setShape(if (isChecked) GradientDrawable.OVAL else GradientDrawable.RECTANGLE)
                .build()
        }

        btnNormal.setOnClickListener {
            ColorPickerPopup.Builder(this)
                .initialColor(shapeView.normalColor) // Set initial color
                .enableAlpha(true) // Enable alpha slider or not
                .okTitle("确定")
                .cancelTitle("取消")
                .showIndicator(true)
                .showValue(true)
                .build()
                .show(it, object : ColorPickerPopup.ColorPickerObserver() {
                    override fun onColorPicked(color: Int) {
                        shapeView.setNormalColor(color)
                            .build()
                    }
                })
        }

        btnPressed.setOnClickListener {
            ColorPickerPopup.Builder(this)
                .initialColor(shapeView.pressedColor) // Set initial color
                .enableAlpha(true) // Enable alpha slider or not
                .okTitle("确定")
                .cancelTitle("取消")
                .showIndicator(true)
                .showValue(true)
                .build()
                .show(it, object : ColorPickerPopup.ColorPickerObserver() {
                    override fun onColorPicked(color: Int) {
                        shapeView.setPressedColor(color)
                            .build()
                    }
                })
        }

        sbStrokeWidth.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                shapeView.setStrokeWidth(50 * progress / 100)
                    .build()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        btnStrokeColor.setOnClickListener {
            ColorPickerPopup.Builder(this)
                .initialColor(shapeView.strokeColor) // Set initial color
                .enableAlpha(true) // Enable alpha slider or not
                .okTitle("确定")
                .cancelTitle("取消")
                .showIndicator(true)
                .showValue(true)
                .build()
                .show(it, object : ColorPickerPopup.ColorPickerObserver() {
                    override fun onColorPicked(color: Int) {
                        shapeView.setStrokeColor(color)
                            .build()
                    }
                })
        }
    }

}