package com.satwinder.mvvm_architecture.ui

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.satwinder.mvvm_architecture.R
import com.satwinder.mvvm_architecture.di.Injectable
import com.satwinder.mvvm_architecture.models.User
import kotlinx.android.synthetic.main.fragment_user.*
import javax.inject.Inject


class UserFragment : Fragment(), Injectable {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var userViewModel: UserViewModel

    private var userList: List<User> = ArrayList<User>()

    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)
        fetchUser()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_users.layoutManager = LinearLayoutManager(activity)
        adapter = UserListAdapter(userList, mContext)
        rv_users.adapter = adapter
        swipeContainer.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            fetchUser()
        })
    }

    fun fetchUser() {
        userViewModel.getuser().observe(this, Observer {
            //todo upadte ui
            if (it != null) {
                if (it.data != null) {
                    userList = it.data
                    adapter.updateList(userList)
                    swipeContainer.isRefreshing = false
                }
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                UserFragment().apply {
                    arguments = Bundle().apply {

                    }
                }

        @SuppressLint("StaticFieldLeak")
        lateinit var mContext: Context
    }
}
