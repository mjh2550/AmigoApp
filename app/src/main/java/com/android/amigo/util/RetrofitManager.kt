package com.android.amigo.util

import android.util.Log
import com.android.amigo.BuildConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.ArrayList

class RetrofitManager() {

    private var baseUrl : String = "http://localhost:8090"
    private val port = BuildConfig.port
    private val ip = BuildConfig.ip

    init {
        baseUrl = "http://$ip:$port"
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * 2022.06.29
     * Get
     * Select All List
     * 리스트 전체 조회 요청
     */
    fun selectAllRequest(request: String) : ArrayList<Any>? {
        var result = ArrayList<Any>()
        retrofit.create(RetrofitService::class.java)
            .getAllList(request)
            .apply {
            enqueue(object : Callback<ArrayList<Any>> {
                override fun onResponse(call: Call<ArrayList<Any>>, response: Response<ArrayList<Any>>) {
                    if (response.isSuccessful) {
                        result = response.body()!!
                        if (result != null) {
                            for(test in result){
                                Log.d("Test","For : $test")
                            }
                        }
                        Log.d("Test", "OnRequest Success : $result")
                    } else {
                        Log.e("Test", "OnRequest Fail")
                    }
                }
                override fun onFailure(call: Call<ArrayList<Any>>, t: Throwable) {
                    Log.d("Test", "On Fail : ${t.message}")
                }
            })
        }
        return result
    }

}