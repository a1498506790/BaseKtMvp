package com.example.basektmvp2.mvp.base

data class BaseBean <T> (val errorCode : Int, val errorMsg : String, val `data` : T)