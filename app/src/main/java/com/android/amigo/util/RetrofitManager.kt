package com.android.amigo.util

import com.android.amigo.data.test.TestVO
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager(myIp : String = "http://localhost:8090") {

    private var baseUrl : String

    init {
        baseUrl = "http://${myIp}:8090"
    }

//   fun buildUrl(myIp : String) { baseUrl = "http://$myIp:8090"}

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//    val service1 = retrofit.create(RetrofitService::class.java)

    fun call(request: String): retrofit2.Call<ArrayList<TestVO>> {
        return retrofit.create(RetrofitService::class.java).getPosts(request)
    }
//    val call = service1.getPosts("getAllList.do")

}