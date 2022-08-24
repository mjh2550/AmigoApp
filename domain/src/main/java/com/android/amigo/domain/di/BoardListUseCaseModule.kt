package com.android.amigo.domain.di

import com.android.amigo.domain.repository.IAmigoRepository
import com.android.amigo.domain.usecase.FetchBoardListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class BoardListUseCaseModule {

    @Provides
    @Singleton
    fun provideFetchBoardListUseCase(
        amigoRepository: IAmigoRepository,
    ): FetchBoardListUseCase {
        return FetchBoardListUseCase(
            amigoRepository = amigoRepository,
        )
    }
}