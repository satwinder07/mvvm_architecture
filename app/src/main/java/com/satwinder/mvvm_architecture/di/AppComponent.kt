package com.satwinder.mvvm_architecture.di

import com.satwinder.mvvm_architecture.ui.UserFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Satwinder on 14/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
@Singleton
@Component(modules = [(AppModule::class), (ApiModule::class)])
interface AppComponent {
   fun inject(userFragment: UserFragment)
}