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

        retrofitRequest("192.168.219.105")
    }

    private fun retrofitRequest(myIp: String) {

        val baseUrl = "http://$myIp:8090"

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service1 = retrofit.create(RetrofitService::class.java)

        val call = service1.getPosts("getAllList.do")

        call.enqueue(object : Callback<ArrayList<TestVO>> {
            override fun onResponse(call: Call<ArrayList<TestVO>>, response: Response<ArrayList<TestVO>>) {
                if (response.isSuccessful) {
                    var result = response.body()

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

            override fun onFailure(call: Call<ArrayList<TestVO>>, t: Throwable) {
                Log.d("Test", "On Fail : ${t.message}")
            }

        })
    }
}