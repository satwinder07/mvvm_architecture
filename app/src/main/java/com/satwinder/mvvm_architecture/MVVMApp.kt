package com.satwinder.mvvm_architecture

import android.app.Activity
import android.support.multidex.MultiDexApplication
import com.satwinder.mvvm_architecture.di.AppComponent
import com.satwinder.mvvm_architecture.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Satwinder on 11/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
class MVVMApp : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingAndroidInjector


    companion object {
        var mAppComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

}