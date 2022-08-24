package com.android.amigo.domain.usecase

import com.android.amigo.domain.repository.IAmigoRepository
import javax.inject.Inject

class FetchBoardListUseCase @Inject constructor(
    private val amigoRepository: IAmigoRepository,
) {
    fun invoke() =
        amigoRepository.getBoardList()

}