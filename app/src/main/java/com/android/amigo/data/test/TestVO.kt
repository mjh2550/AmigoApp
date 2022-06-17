package com.android.amigo.data.test

import com.google.gson.annotations.SerializedName

data class TestVO(
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String
)
