package com.android.amigo.data.repository

import com.android.amigo.domain.repository.IAmigoRepository
import javax.inject.Inject

class AmigoRepository @Inject constructor(
) : IAmigoRepository {

    override fun getBoardList(): ArrayList<Any> = ArrayList()
}