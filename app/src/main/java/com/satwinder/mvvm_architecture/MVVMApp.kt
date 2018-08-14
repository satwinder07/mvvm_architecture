package com.satwinder.mvvm_architecture

import android.support.multidex.MultiDexApplication
import com.satwinder.mvvm_architecture.di.AppComponent
import com.satwinder.mvvm_architecture.di.AppModule
import com.satwinder.mvvm_architecture.di.DaggerAppComponent

/**
 * Created by Satwinder on 11/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
class MVVMApp : MultiDexApplication() {
    companion object {
        var mAppComponent:AppComponent? =null
    }

    override fun onCreate() {
        super.onCreate()
        mAppComponent = createAppComponent()
    }

    fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}