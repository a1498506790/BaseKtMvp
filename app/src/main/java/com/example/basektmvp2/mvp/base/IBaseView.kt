package com.example.basektmvp2.mvp.base

import com.example.basektmvp2.widget.status.OnFailClickListener

interface IBaseView {

    fun showLoading()

    fun showWaitLoading()

    fun showFail(onFailClickListener: OnFailClickListener)

    fun showEmpty()

    fun hide()

}