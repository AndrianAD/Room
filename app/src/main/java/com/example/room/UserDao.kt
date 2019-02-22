package com.example.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Query


@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM users")
    fun getAll(): LiveData<List<User>>


}