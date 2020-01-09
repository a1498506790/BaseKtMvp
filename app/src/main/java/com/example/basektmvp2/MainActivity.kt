package com.example.basektmvp2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.basektmvp2.base.BaseActivity
import com.example.basektmvp2.mvp.base.BaseBean
import com.example.basektmvp2.mvp.base.NetModel
import com.example.basektmvp2.mvp.callback.NetCallback
import com.example.basektmvp2.net.Api
import com.example.basektmvp2.ui.multistate.MultiStateActivity
import com.example.basektmvp2.ui.page_mvp.PageMvpActivity
import com.example.basektmvp2.ui.shape.ShapeViewActivity
import com.example.basektmvp2.ui.simple_mvp.activity.SimpleMvpActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initToolbar("演示功能")
        btnMultiState.setOnClickListener {
            startActivity(Intent(this, MultiStateActivity::class.java))
        }
        btnSimpleMvp.setOnClickListener {
            startActivity(Intent(this, SimpleMvpActivity::class.java))
        }
        btnPageMvp.setOnClickListener {
            startActivity(Intent(this, PageMvpActivity::class.java))
        }

        btnShapeView.setOnClickListener {
            startActivity(Intent(this, ShapeViewActivity::class.java))
        }
    }

}
