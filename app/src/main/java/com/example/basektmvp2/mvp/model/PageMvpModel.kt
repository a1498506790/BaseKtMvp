package com.example.basektmvp2.mvp.model

import com.example.basektmvp2.mvp.base.ListBean
import com.example.basektmvp2.mvp.callback.NetCallback
import com.example.basektmvp2.mvp.contract.PageMvpContract
import com.example.basektmvp2.ui.page_mvp.bean.PageMvpBean

class PageMvpModel : PageMvpContract.Model() {

    override fun getData(page: Int, netCallback: NetCallback<ListBean<PageMvpBean>>) {
        val url = "/wxarticle/list/408/$page/json"
        get(url, netCallback)
    }

}