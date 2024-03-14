package com.example.timetonictest.network.di

import com.example.timetonictest.login.data.dataAccess.LoginService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object TimetonicModule {
    @Provides
    @Singleton
    fun provideTimetonicService(retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }
}