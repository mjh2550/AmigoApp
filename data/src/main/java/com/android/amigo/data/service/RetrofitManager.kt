package com.android.amigo.data.service

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager(
    private val ip: String = "localhost",
    private val port: Int = 8090,
    val context: Context,
) {

    private var baseUrl: String = "http://$ip:$port"
//    var ip = AmigoApplication().getMetaDataString("APP_WAS_HOST",context)
    //포트는 항상 숫자이므로 Int 로 요청해야 함
//    var port = AmigoApplication().getMetaDataInteger("APP_WAS_PORT",context)

/*
    init {
        if(ip!!.isNotEmpty() && port!=-1) baseUrl = "http://$ip:$port"
    }
*/

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}