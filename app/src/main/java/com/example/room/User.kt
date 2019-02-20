package com.example.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "users")
data class User(@NonNull var name: String,
                @NonNull var age: Int,
                var isWork: Boolean){
@PrimaryKey(autoGenerate = true) var userId: Int? = null }