package com.satwinder.mvvm_architecture.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.satwinder.mvvm_architecture.R
import com.satwinder.mvvm_architecture.models.User
import kotlinx.android.synthetic.main.user_item.view.*
import com.satwinder.mvvm_architecture.utils.MyDiffCallback
import android.support.v7.util.DiffUtil



/**
 * Created by Satwinder on 13/08/18.
 * Appstreet software private Ltd
 * satwinder.singh@appstreet.io
 */
class UserListAdapter(item:List<User>, val context:Context): RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private val items = mutableListOf<User>()

    init {
        items.addAll(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_item,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val user:User = items.get(position)
         holder.tvName.text = user.name
         holder.tvCompany.text = user.company
    }


    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tvName = view.txt_name
        val tvCompany = view.txt_company
    }

    fun updateList(list:List<User>){
        val diffResult = DiffUtil.calculateDiff(MyDiffCallback(this.items, list))
        this.items.clear()
        this.items.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    fun addAll(list:List<User>){
        this.items.addAll(list)
        notifyDataSetChanged()
    }
}