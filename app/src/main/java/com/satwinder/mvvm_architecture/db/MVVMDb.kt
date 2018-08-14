package com.satwinder.mvvm_architecture.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.satwinder.mvvm_architecture.models.User

/**
 * Created by Satwinder on 14/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
@Database(entities = [User::class], version = 1)
public abstract class MVVMDb: RoomDatabase() {
    abstract fun userDao(): UserDAO
}