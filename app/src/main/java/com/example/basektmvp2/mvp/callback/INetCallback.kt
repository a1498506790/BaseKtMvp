package com.example.basektmvp2.mvp.callback

interface INetCallback {

    fun success(json: String)

    fun fail(t: Throwable)

}