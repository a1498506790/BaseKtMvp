package com.example.basektmvp2.mvp.base

import com.example.basektmvp2.mvp.callback.INetCallback
import com.example.basektmvp2.net.NetClient
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class NetModel : BaseModel() {

    var iNetCallback: INetCallback? = null

    private val emptyParams by lazy { HashMap<String, String>() }

    fun get(url: String, iNetCallback: INetCallback, params: Map<String, String> = emptyParams) {
        this.iNetCallback = iNetCallback
        NetClient.instance
            .createApi()
            .get(url, params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun post(url: String, iNetCallback: INetCallback, params: Map<String, String> = emptyParams) {
        this.iNetCallback = iNetCallback
        NetClient.instance
            .createApi()
            .post(url, params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }


    private val observer = object : Observer<String> {

        override fun onComplete() {}

        override fun onSubscribe(d: Disposable) {
            addDisposable(d)
        }

        override fun onNext(t: String) {
            iNetCallback?.success(t)
        }

        override fun onError(e: Throwable) {
            iNetCallback?.fail(e)
        }

    }

}