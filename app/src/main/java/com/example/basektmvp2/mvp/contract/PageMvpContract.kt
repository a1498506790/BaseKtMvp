package com.example.basektmvp2.mvp.contract

import com.example.basektmvp2.mvp.base.*
import com.example.basektmvp2.mvp.callback.NetCallback
import com.example.basektmvp2.ui.page_mvp.bean.PageMvpBean

interface PageMvpContract {

    interface View : IPageView{
        fun getDataSuccess(list: ArrayList<PageMvpBean>, loadStatus: LoadStatus)
    }

    abstract class Model : NetModel(){
        abstract fun getData(page: Int, netCallback: NetCallback<ListBean<PageMvpBean>>)
    }

    abstract class Presenter : BasePresenter<View, Model>(){
        abstract fun getData(loadStatus: LoadStatus)
    }

}