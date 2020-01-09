package com.example.basektmvp2.mvp.model

import com.example.basektmvp2.ui.simple_mvp.bean.SimpleMvpBean
import com.example.basektmvp2.mvp.callback.NetCallback
import com.example.basektmvp2.mvp.contract.SimpleMvpContract
import com.example.basektmvp2.net.Api

class SimpleMvpModel : SimpleMvpContract.Model() {

    override fun getData(netCallback: NetCallback<ArrayList<SimpleMvpBean>>) {
        get(Api.TEST, netCallback)
    }
}