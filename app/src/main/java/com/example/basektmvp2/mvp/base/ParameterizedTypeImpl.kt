package com.example.basektmvp2.mvp.base

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class ParameterizedTypeImpl(var raw : Class<*>, var args: Array<Type>) : ParameterizedType {

    override fun getActualTypeArguments() = args

    override fun getRawType() = raw

    override fun getOwnerType() = null

}