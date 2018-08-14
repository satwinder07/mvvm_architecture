package com.satwinder.mvvm_architecture.api

import android.arch.lifecycle.LiveData
import com.satwinder.mvvm_architecture.models.User
import retrofit2.http.GET


/**
 * Created by Satwinder on 11/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
interface ApiCalls {

    @GET("users")
    fun getUser(): LiveData<ApiResponse<List<User>>>
}