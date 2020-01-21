package com.example.basektmvp2.base

import android.app.Application
import android.content.Context

class App : Application(){

    companion object{
        lateinit var app : App
        val context: Context by lazy { app.applicationContext }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }

}