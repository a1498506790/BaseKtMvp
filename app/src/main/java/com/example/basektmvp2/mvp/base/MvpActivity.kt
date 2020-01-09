package com.example.basektmvp2.mvp.base

import android.os.Bundle
import com.example.basektmvp2.base.BaseActivity

abstract class MvpActivity<P: BasePresenter<*, *>> : BaseActivity(), IBaseView{

    val presenter by lazy { createPresenter() }
    abstract fun createPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter.attachView(this)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

}