package com.example.basektmvp2.mvp.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseModel {

    private val compositeDisposable by lazy { CompositeDisposable() }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun clearDisposable() {
        compositeDisposable.clear()
    }

}