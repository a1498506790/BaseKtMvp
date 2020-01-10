package com.example.basektmvp2.utils

import com.google.gson.Gson
import java.lang.reflect.Type

class GsonUtils {

    companion object{
        private val gson by lazy { Gson() }

        fun <T> jsonToBean(json: String, type: Type) : T{
            return gson.fromJson(json, type)
        }

    }

}