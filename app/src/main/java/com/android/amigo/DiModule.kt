package com.android.amigo

import com.android.amigo.repository.AmigoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DiModule {

    @Singleton
    @Provides
    fun provideAmigoRepository() : AmigoRepository{
        return AmigoRepository()
    }
}