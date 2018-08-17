package com.satwinder.mvvm_architecture.utils

import android.support.v7.util.DiffUtil
import com.satwinder.mvvm_architecture.models.User


/**
 * Created by Satwinder on 13/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
class MyDiffCallback(internal var newUser: List<User>, internal var oldUser: List<User>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldUser.size
    }

    override fun getNewListSize(): Int {
        return newUser.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldUser[oldItemPosition].id === newUser[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldUser[oldItemPosition].name == newUser[newItemPosition].name &&
                oldUser[oldItemPosition].company == newUser[newItemPosition].company
    }

}