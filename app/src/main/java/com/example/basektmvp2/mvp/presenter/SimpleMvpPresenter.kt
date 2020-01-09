package com.example.basektmvp2.mvp.presenter
import com.example.basektmvp2.ui.simple_mvp.bean.SimpleMvpBean
import com.example.basektmvp2.mvp.base.BaseBean
import com.example.basektmvp2.mvp.callback.NetCallback
import com.example.basektmvp2.mvp.contract.SimpleMvpContract
import com.example.basektmvp2.mvp.model.SimpleMvpModel
import com.example.basektmvp2.widget.status.OnFailClickListener

class SimpleMvpPresenter : SimpleMvpContract.Presenter(){

    override fun createModel(): SimpleMvpContract.Model = SimpleMvpModel()

    override fun getData() {
        view?.let {
            it.showLoading()
            model.getData(object : NetCallback<ArrayList<SimpleMvpBean>>(){
                override fun onSuccess(bean: BaseBean<ArrayList<SimpleMvpBean>>) {
                    it.hide()
                    it.getDataSuccess(bean.data)
                }

                override fun onFail(code: Int, msg: String) {
                    it.showFail(object : OnFailClickListener{
                        override fun click() {
                            getData()
                        }
                    })
                }
            })
        }
    }



}