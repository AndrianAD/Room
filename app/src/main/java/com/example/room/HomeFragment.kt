package com.example.room


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       var view = inflater.inflate(R.layout.fragment_home, container, false)

        view.newUserButton.setOnClickListener {
            MainActivity.manager!!.beginTransaction().replace(R.id.frame_fragment, AddUser()).addToBackStack("Back").commit()

        }
        return view
    }
}
