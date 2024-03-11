package com.example.timetonictest.network.di

import com.example.timetonictest.login.dataAccess.LoginService
import dagger.Module
import dagger.hilt.InstallIn
import retrofit2.Retrofit

@Module
@InstallIn
object TimetonicModule {
    fun provideTimetonicService(retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }
}