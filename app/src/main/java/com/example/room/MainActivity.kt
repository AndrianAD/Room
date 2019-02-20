package com.example.room

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.arch.lifecycle.ViewModelProviders
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object fragmentManager {
        var manager: FragmentManager? = null
        lateinit var viewModel:UserViewModel
    }

    init {
        manager = supportFragmentManager
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_fragment, HomeFragment())
                    .commit()
        }

        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        viewModel.getAllUsers().observe(this, Observer { textView.setText(it.toString())})
    }



}
