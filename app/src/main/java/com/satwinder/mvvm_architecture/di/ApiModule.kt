package com.satwinder.mvvm_architecture.di

import android.arch.lifecycle.ViewModelProvider
import com.satwinder.mvvm_architecture.api.ApiCalls
import com.satwinder.mvvm_architecture.utils.LiveDataCallAdapterFactory
import com.satwinder.mvvm_architecture.viewmodel.MVVMViewModelFactory
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by Satwinder on 14/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideApiCalls(converterFactory: Converter.Factory): ApiCalls {
        return Retrofit.Builder()
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .baseUrl("https://private-c6a06-appstreet.apiary-mock.com/")
                .build()
                .create(ApiCalls::class.java)
    }


}