package com.example.basektmvp2.mvp.base

import androidx.annotation.CallSuper

abstract class BasePresenter<V : IBaseView, M : BaseModel> {

    var view: V? = null

    val model: M by lazy { createModel() }

    abstract fun createModel(): M

    @Suppress("UNCHECKED_CAST")
    fun attachView(view: IBaseView) {
        this.view = view as V
    }

    @CallSuper //子类重写改方法必须调用的方法，防止子类重写后没有调用造成内存泄漏
    fun detachView() {
        view = null
        model.clearDisposable()
    }
}