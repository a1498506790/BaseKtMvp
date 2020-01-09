package com.example.basektmvp2.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class NetClient {

    private lateinit var retrofit2: Retrofit

    companion object {
        val instance by lazy { NetClient() }
    }

    init {
        val okHttpClient = OkHttpClient.Builder()
            .build()
        retrofit2 = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun createApi(): ApiService {
        return retrofit2.create(ApiService::class.java)
    }

}