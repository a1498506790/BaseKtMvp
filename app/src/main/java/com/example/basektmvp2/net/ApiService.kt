package com.example.basektmvp2.net

import io.reactivex.Observable
import retrofit2.http.*

interface ApiService {

    @GET
    fun get(@Url url: String, @QueryMap params: Map<String, String>): Observable<String>

    @FormUrlEncoded
    @POST
    fun post(@Url url: String, @FieldMap params: Map<String, String>): Observable<String>

}