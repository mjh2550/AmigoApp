package com.android.amigo.domain.repository

import com.android.amigo.domain.model.TestData
import retrofit2.Call

interface IAmigoRepository {

    fun getBoardList(): Call<ArrayList<TestData>>
}