package com.example.room

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.util.Log
import java.util.ArrayList

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val TAG = javaClass.simpleName
    private var userDao : UserDao? = null
     var userDB : UserRoomDatabase
    var allUsers: LiveData<List<User>>

    init {
        userDB= UserRoomDatabase.getInstance(application)!!
        userDao=userDB.userDao()
        allUsers=userDB.userDao().getAll()
    }



    override fun onCleared() {
        super.onCleared()
        Log.i(TAG,"Viewmodel destroyed")
    }
}