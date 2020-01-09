package com.example.basektmvp2.mvp.base

data class ListBean<T>(
    val curPage: Int,
    val datas: ArrayList<T>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)