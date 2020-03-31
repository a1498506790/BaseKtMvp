package com.example.basektmvp2

import android.content.Intent
import android.os.Bundle
import com.example.basektmvp2.base.BaseActivity
import com.example.basektmvp2.dialog.TestDialog
import com.example.basektmvp2.ui.image.ImageActivity
import com.example.basektmvp2.ui.multistate.MultiStateActivity
import com.example.basektmvp2.ui.page_mvp.PageMvpActivity
import com.example.basektmvp2.ui.simple_mvp.activity.SimpleMvpActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initToolbar("演示功能").navigationIcon = null
        btnMultiState.setOnClickListener {
            startActivity(Intent(this, MultiStateActivity::class.java))
        }
        btnSimpleMvp.setOnClickListener {
            startActivity(Intent(this, SimpleMvpActivity::class.java))
        }
        btnPageMvp.setOnClickListener {
            startActivity(Intent(this, PageMvpActivity::class.java))
        }
        btnImageView.setOnClickListener {
            startActivity(Intent(this, ImageActivity::class.java))
        }
        btnDialog.setOnClickListener {
            val testDialog = TestDialog()
            testDialog.show(supportFragmentManager)
        }
    }

}
