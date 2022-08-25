package com.android.amigo.data.repository

import android.content.Context
import com.android.amigo.data.service.RetrofitService
import com.android.amigo.domain.model.TestData
import com.android.amigo.domain.repository.IAmigoRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import javax.inject.Inject

class AmigoRepository @Inject constructor(
    @ApplicationContext private val context: Context
) : IAmigoRepository {

//    var ip = AmigoApplication().getMetaDataString("APP_WAS_HOST",context)
    //포트는 항상 숫자이므로 Int 로 요청해야 함
//    var port = AmigoApplication().getMetaDataInteger("APP_WAS_PORT",context)

    private var ip = "192.168.3.36"
    private var port = 8090

    //    private val instance = RetrofitManager(ip, port, context).retrofit
    private val api = RetrofitService.create("http://$ip:$port")

    override fun getBoardList(): Call<ArrayList<TestData>> = api.getAllList("getAllList.do")


}