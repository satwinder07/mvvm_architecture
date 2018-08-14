package com.satwinder.mvvm_architecture.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.satwinder.mvvm_architecture.repository.UserRepository
import com.satwinder.mvvm_architecture.ui.UserViewModel
import javax.inject.Inject


/**
 * Created by Satwinder on 14/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
class UserViewModelFactory @Inject constructor(private val userRepository: UserRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}