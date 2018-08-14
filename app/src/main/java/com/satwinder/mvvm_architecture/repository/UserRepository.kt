package com.satwinder.mvvm_architecture.repository

import android.arch.lifecycle.LiveData
import com.satwinder.mvvm_architecture.api.ApiCalls
import com.satwinder.mvvm_architecture.db.UserDAO
import com.satwinder.mvvm_architecture.models.Resource
import com.satwinder.mvvm_architecture.models.User
import com.satwinder.mvvm_architecture.utils.AppExecutors
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Satwinder on 13/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
@Singleton
class UserRepository @Inject constructor(private val apiCalls: ApiCalls, private val userDAO: UserDAO, private val appExecutors: AppExecutors) {

    fun loadUser(): LiveData<Resource<List<User>>> {
        return object : NetworkBoundResource<List<User>, List<User>>(appExecutors) {
            override fun saveCallResult(item: List<User>) {
                userDAO.insertAll(item)
            }
            override fun shouldFetch(data: List<User>?): Boolean {
                return true
            }

            override fun loadFromDb() = userDAO.loadAllUser()

            override fun createCall() = apiCalls.getUser()
        }.asLiveData()
    }

}