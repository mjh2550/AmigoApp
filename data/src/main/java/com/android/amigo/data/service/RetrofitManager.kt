package com.android.amigo.data.service

import android.content.Context
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * 2022.06.29
     * Get
     * Select All List
     * 리스트 전체 조회 요청
     * @author mjh
     * @param request
     */
    fun selectAllRequest(request: String): ArrayList<Any>? {
        var result = ArrayList<Any>()
        retrofit.create(RetrofitService::class.java)
            .getAllList(request)
            .apply {
                enqueue(object : Callback<ArrayList<Any>> {
                    override fun onResponse(
                        call: Call<ArrayList<Any>>,
                        response: Response<ArrayList<Any>>
                    ) {
                        if (response.isSuccessful) {
                            result = response.body()!!
                            for (test in result) {
                                Log.d("Test", "For : $test")
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
        Log.d("Test", "Onreturn : $result")
        return result
    }

}