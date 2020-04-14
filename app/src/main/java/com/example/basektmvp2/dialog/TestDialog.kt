package com.example.basektmvp2.dialog

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.FragmentManager
import com.example.basektmvp2.R
import kotlinx.android.synthetic.main.dialog_test.*

class TestDialog : BaseDialogFragment(){

    override fun getLayoutId() = R.layout.dialog_test

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvTest.text = "123"
    }

    override fun onStart() {
        super.onStart()
        setGravity(Gravity.CENTER)
    }

    fun show(manager: FragmentManager) {
        super.show(manager, TestDialog::javaClass.name)
    }

}