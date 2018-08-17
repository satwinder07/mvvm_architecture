package com.satwinder.mvvm_architecture.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.satwinder.mvvm_architecture.models.Resource
import com.satwinder.mvvm_architecture.models.User
import com.satwinder.mvvm_architecture.repository.UserRepository
import javax.inject.Inject


/**
 * Created by Satwinder on 11/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    fun getuser():LiveData<Resource<List<User>>>{
       return userRepository.loadUser()
    }

}