package com.android.amigo.data.di

import android.content.Context
import com.android.amigo.data.repository.AmigoRepository
import com.android.amigo.domain.repository.IAmigoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAmigoRepository(
        @ApplicationContext context: Context
    ): IAmigoRepository {
        return AmigoRepository(context)
    }


}