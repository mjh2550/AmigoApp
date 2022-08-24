package com.android.amigo.data.di

import com.android.amigo.data.repository.AmigoRepository
import com.android.amigo.domain.repository.IAmigoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAmigoRepository(
    ): IAmigoRepository {
        return AmigoRepository()
    }


}