package com.example.basektmvp2.mvp.base

abstract class BasePresenter<V : IBaseView, M : BaseModel> {

    var view: V? = null

    val model: M by lazy { createModel() }

    abstract fun createModel(): M

    @Suppress("UNCHECKED_CAST")
    fun attachView(view: IBaseView) {
        this.view = view as V
    }

    fun detachView() {
        view = null
        model.clearDisposable()
    }
}