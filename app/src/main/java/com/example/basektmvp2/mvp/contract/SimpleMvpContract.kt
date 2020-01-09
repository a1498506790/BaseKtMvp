package com.example.basektmvp2.mvp.contract

import com.example.basektmvp2.ui.simple_mvp.bean.SimpleMvpBean
import com.example.basektmvp2.mvp.base.BasePresenter
import com.example.basektmvp2.mvp.base.IBaseView
import com.example.basektmvp2.mvp.base.NetModel
import com.example.basektmvp2.mvp.callback.NetCallback

interface SimpleMvpContract{

    interface View : IBaseView{
        fun getDataSuccess(list : ArrayList<SimpleMvpBean>)
    }

    abstract class Model : NetModel(){
        abstract fun getData(netCallback: NetCallback<ArrayList<SimpleMvpBean>>)
    }

    abstract class Presenter : BasePresenter<View, Model>(){
        abstract fun getData()
    }

}