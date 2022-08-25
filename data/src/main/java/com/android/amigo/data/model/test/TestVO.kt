package com.android.amigo.data.model.test

import com.android.amigo.domain.model.TestData
import com.google.gson.annotations.SerializedName

data class TestVO(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
) {
    fun toTestData() =
        TestData(
            id = this.id,
            name = this.name
        )
}
