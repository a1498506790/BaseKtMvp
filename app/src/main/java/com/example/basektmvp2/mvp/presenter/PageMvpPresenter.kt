package com.example.basektmvp2.mvp.presenter

import com.example.basektmvp2.mvp.base.BaseBean
import com.example.basektmvp2.mvp.base.ListBean
import com.example.basektmvp2.mvp.base.LoadStatus
import com.example.basektmvp2.mvp.callback.NetCallback
import com.example.basektmvp2.mvp.contract.PageMvpContract
import com.example.basektmvp2.mvp.model.PageMvpModel
import com.example.basektmvp2.ui.page_mvp.bean.PageMvpBean
import com.example.basektmvp2.widget.status.OnFailClickListener

class PageMvpPresenter : PageMvpContract.Presenter() {

    override fun createModel() = PageMvpModel()

    var page = 1

    override fun getData(loadStatus: LoadStatus) {
        view?.let {
            if (loadStatus == LoadStatus.REFRESH) page = 1
            if (loadStatus == LoadStatus.LOADING) it.showLoading()
            model.getData(page, object : NetCallback<ListBean<PageMvpBean>>(){
                override fun onSuccess(bean: BaseBean<ListBean<PageMvpBean>>) {
                    if (loadStatus == LoadStatus.REFRESH) it.finishRefresh()
                    if (loadStatus == LoadStatus.LOADING) it.hide()
                    it.getDataSuccess(bean.data.datas, loadStatus)
                    it.loadMoreEnd(bean.data.over)
                    page++
                }

                override fun onFail(code: Int, msg: String) {
                    if (loadStatus == LoadStatus.LOADING){
                        it.showFail(object : OnFailClickListener{
                            override fun click() {
                                getData(loadStatus)
                            }
                        })
                    }else{
                        it.loadMoreFail()
                    }
                }
            })
        }
    }

}