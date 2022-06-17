package com.android.amigo

import com.android.amigo.repository.AmigoRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DiModule {

    fun provideAmigoRepository() : AmigoRepository{
        return AmigoRepository()
    }
}