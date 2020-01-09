package com.example.basektmvp2.mvp.base

interface IPageView : IBaseView{

    fun loadMoreEnd(isEnd: Boolean)

    fun loadMoreFail()

    fun finishRefresh()

}