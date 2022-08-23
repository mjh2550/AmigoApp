package com.android.amigo.data.service

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("mobile/v1/api/{request}")
    fun getAllList(@Path("request") request: String) : retrofit2.Call<ArrayList<Any>>

}