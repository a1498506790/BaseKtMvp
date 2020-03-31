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

}