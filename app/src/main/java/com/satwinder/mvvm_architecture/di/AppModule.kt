package com.satwinder.mvvm_architecture.di

import android.app.Application
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
@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(app: Application): Context {
        return app.applicationContext
    }


    @Singleton
    @Provides
    fun provideDb(app: Application): MVVMDb {
        return Room
                .databaseBuilder(app, MVVMDb::class.java, "mvvm.db")
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