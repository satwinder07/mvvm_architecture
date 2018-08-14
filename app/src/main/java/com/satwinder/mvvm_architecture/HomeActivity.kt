package com.satwinder.mvvm_architecture

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.satwinder.mvvm_architecture.ui.UserFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val firstFragment = UserFragment()
        firstFragment.arguments = intent.extras
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, firstFragment)
        transaction.commit()
    }
}

