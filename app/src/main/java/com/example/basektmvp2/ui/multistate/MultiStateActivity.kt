package com.example.basektmvp2.ui.multistate

import android.os.Bundle
import android.widget.Toast
import com.example.basektmvp2.R
import com.example.basektmvp2.base.BaseActivity
import com.example.basektmvp2.widget.status.MultiStateLayout
import com.example.basektmvp2.widget.status.OnFailClickListener
import kotlinx.android.synthetic.main.activity_multi_state.*

class MultiStateActivity : BaseActivity(){

    override fun getLayoutId() = R.layout.activity_multi_state

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initToolbar("演示多状态布局")
        btnLoading.setOnClickListener {
            showLoading()
        }
        btnEmpty.setOnClickListener {
           showEmpty()
        }
        btnFail.setOnClickListener {
           showFail(object : OnFailClickListener{
               override fun click() {
                   Toast.makeText(this@MultiStateActivity, "点击了", Toast.LENGTH_SHORT).show()
               }
           })
        }
        btnWaitLoading.setOnClickListener {
            showWaitLoading()
        }
        btnHide.setOnClickListener {
            multiStateLayout.setStatus(MultiStateLayout.STATUS_HIDE)
        }
    }

}