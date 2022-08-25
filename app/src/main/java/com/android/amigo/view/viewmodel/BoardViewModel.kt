package com.android.amigo.view.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.amigo.domain.model.TestData
import com.android.amigo.domain.usecase.FetchBoardListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class BoardViewModel @Inject constructor(
    private val fetchBoardListUseCase: FetchBoardListUseCase,
) : ViewModel() {

    var ldata = MutableLiveData<ArrayList<TestData>>()
    val list = ArrayList<TestData>()

//    private val _liveData = MutableLiveData<TestData>()
//    val liveData: LiveData<TestData> get() = _liveData
//
//    fun loadData(testData: TestData) = viewModelScope.launch {
//        _liveData.value = testData
//        _liveData.postValue(testData)
//    }

    fun load() {
        val call = fetchBoardListUseCase.invoke()
        call.enqueue(object : Callback<ArrayList<TestData>> {
            override fun onResponse(
                call: Call<ArrayList<TestData>>,
                response: Response<ArrayList<TestData>>
            ) {
                if (response.isSuccessful) {
                    var result = response.body()!!
                    for (test in result) {
                        Log.d("Test", "For : $test")
                        list.add(test)
                    }
                    ldata.value = list
                    Log.d("Test", "OnRequest Success : $result")
                } else {
                    Log.e("Test", "OnRequest Fail")
                }
            }

            override fun onFailure(call: Call<ArrayList<TestData>>, t: Throwable) {
                Log.d("Test", "On Fail : ${t.message}")
            }
        })
    }
}