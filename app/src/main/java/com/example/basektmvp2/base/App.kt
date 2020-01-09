package com.example.basektmvp2.base

import android.app.Application
import android.content.Context

class App : Application(){

    companion object{
        var app : App? = null
        fun getContext() : Context?{
            return app?.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }

}