package com.example.room

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_view.view.*


class UserAdapter(val context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    var items: List<User>? = null

    fun setItemList(items: List<User>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_view, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (items != null)
            items!!.size
        else
            0
    }

    override fun onBindViewHolder(parent: UserViewHolder, position: Int) {

        if (items != null) {

            parent.name.setText(items!![position].name)
            var userAge = items!![position].age
            parent.age.setText(userAge.toString())
        } else {
            parent.name.setText("EMPTY")
            parent.age.setText("EMPTY")
        }

    }


    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name = view.name_id
        var age = view.age_id
    }
}