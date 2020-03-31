package com.example.basektmvp2.dialog

import androidx.fragment.app.FragmentManager
import com.example.basektmvp2.R

class TestDialog : BaseDialogFragment(){

    override fun getLayoutId() = R.layout.dialog_test

    fun show(manager: FragmentManager) {
        super.show(manager, TestDialog::javaClass.name)
    }

}