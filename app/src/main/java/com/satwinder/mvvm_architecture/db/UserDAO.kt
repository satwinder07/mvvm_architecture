package com.satwinder.mvvm_architecture.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.satwinder.mvvm_architecture.models.User

/**
 * Created by Satwinder on 14/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(user: List<User>)

    @Query("SELECT * FROM user WHERE id = :id")
    fun findById(id: Int): LiveData<User>

    @Query("SELECT * FROM user")
    fun loadAllUser(): LiveData<List<User>>
}