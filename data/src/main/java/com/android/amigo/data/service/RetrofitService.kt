package com.android.amigo.data.service

import com.android.amigo.domain.model.TestData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    companion object {

        private var BASE_URL = "http://localhost:8090"

        fun create(
            baseUrlString: String = BASE_URL,
        ): RetrofitService {
//            var gson = GsonBuilder()
//                .setLenient()
//                .create()

            return Retrofit.Builder()
                .baseUrl(baseUrlString)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService::class.java)
        }
    }


    @GET("mobile/v1/api/{request}")
    fun getAllList(@Path("request") request: String): retrofit2.Call<ArrayList<TestData>>

}