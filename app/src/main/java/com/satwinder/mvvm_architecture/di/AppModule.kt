package com.satwinder.mvvm_architecture.di

import android.arch.persistence.room.Room
import android.content.Context
import com.satwinder.mvvm_architecture.MVVMApp
import com.satwinder.mvvm_architecture.db.MVVMDb
import com.satwinder.mvvm_architecture.db.UserDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Satwinder on 14/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
@Module
class AppModule(internal val mMVVMApp: MVVMApp) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return mMVVMApp.applicationContext
    }


    @Singleton
    @Provides
    fun provideDb(): MVVMDb {
        return Room
                .databaseBuilder(mMVVMApp, MVVMDb::class.java, "mvvm.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries() //todo remove this later
                .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: MVVMDb): UserDAO {
        return db.userDao()
    }
}