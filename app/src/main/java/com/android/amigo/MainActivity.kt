package com.android.amigo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.amigo.data.test.TestVO
import com.android.amigo.util.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var BASE_URL = "http://192.168.3.29:8090"

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service1 = retrofit.create(RetrofitService::class.java)

        val call = service1.getPosts("getAllList.do")

         call.enqueue(object : Callback<TestVO>{
             override fun onResponse(call: Call<TestVO>, response: Response<TestVO>) {
                 if(response.isSuccessful){
                     val result  = response.body()
                     Log.d("Test", "OnRequest Success : $result")
                 }else{
                     Log.d("Test", "OnRequest Fail")
                 }

             }

             override fun onFailure(call: Call<TestVO>, t: Throwable) {
                 Log.d("Test", "On Fail : ${t.message}")
             }

         })
    }
}