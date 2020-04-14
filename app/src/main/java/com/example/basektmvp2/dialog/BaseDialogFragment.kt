package com.example.basektmvp2.dialog
import android.os.Bundle
import android.view.*
import androidx.annotation.CallSuper
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(getLayoutId(), container, true)
    }

    abstract fun getLayoutId(): Int

    @CallSuper
    override fun onStart() {
        super.onStart()
        val window = dialog?.window
        window?.let {
            it.setBackgroundDrawableResource(android.R.color.transparent)
            val attributes = it.attributes
            attributes.gravity = Gravity.CENTER
            attributes.width = WindowManager.LayoutParams.MATCH_PARENT
            it.attributes = attributes
        }
    }

    /**
     * 设置弹框弹出得位置
     */
    fun setGravity(gravity : Int){
        val window = dialog?.window
        window?.let {
            val attributes = it.attributes
            attributes.gravity = gravity
            it.attributes = attributes
        }
    }

    /**
     * 设置弹框的进出动画
     */
    fun setWindowAnimations(windowAnimations : Int){
        val window = dialog?.window
        window?.let {
            val attributes = it.attributes
            attributes.windowAnimations = windowAnimations
            it.attributes = attributes
        }
    }

}