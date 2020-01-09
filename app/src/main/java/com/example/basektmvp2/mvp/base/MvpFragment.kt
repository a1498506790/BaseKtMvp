package com.example.basektmvp2.mvp.base

import android.os.Bundle
import com.example.basektmvp2.base.BaseFragment

abstract class MvpFragment<P : BasePresenter<*, *>> : BaseFragment(), IBaseView {

    val presenter by lazy { createPresenter() }
    abstract fun createPresenter(): P

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        presenter.attachView(this)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

}