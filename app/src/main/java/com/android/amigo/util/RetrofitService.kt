package com.android.amigo.util

import android.telecom.Call
import com.android.amigo.data.test.TestVO
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitService {

    @GET("mobile/v1/api/{request}")
    fun getAllList(@Path("request") request: String) : retrofit2.Call<ArrayList<Any>>

}