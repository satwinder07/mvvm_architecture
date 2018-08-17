package com.satwinder.mvvm_architecture.di

import android.app.Application
import com.satwinder.mvvm_architecture.MVVMApp
import com.satwinder.mvvm_architecture.ui.UserFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Satwinder on 14/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
@Singleton
@Component(modules = [AppModule::class, ApiModule::class, AndroidInjectionModule::class, MainActivityModule::class])
interface AppComponent {
   @Component.Builder
   interface Builder {
      @BindsInstance
      fun application(application: Application): Builder

      fun build(): AppComponent
   }

   fun inject(mvvmApp: MVVMApp)
}