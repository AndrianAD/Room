package com.example.room


import android.os.AsyncTask
import android.os.Build.VERSION_CODES.M
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.room.R.id.age
import com.example.room.R.id.name
import kotlinx.android.synthetic.main.fragment_add_user.*
import kotlinx.android.synthetic.main.fragment_add_user.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AddUser : Fragment() {
    private val TAG = javaClass.simpleName
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_add_user, container, false)

        view.save_button.setOnClickListener {
            val userName = view.name.text.toString()
            val userAge = if (!view.age.text.isEmpty()) Integer.parseInt(view.age.text.toString()) else 0
            val userHaveJob = isWork.isChecked
            var userDao = MainActivity.viewModel.userDB.userDao()

            InsertAsyncTask(userDao).execute(User(userName, userAge, userHaveJob))


        }

        return view
    }

    inner class InsertAsyncTask(var userDao: UserDao) : AsyncTask<User, Void, Void>() {
        override fun doInBackground(vararg users: User): Void? {
            userDao.insert(users[0])
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            Log.i(TAG,"User Added OK")
            Toast.makeText(activity,"Cделано Успешно",Toast.LENGTH_LONG).show()
            name.text.clear()
            age.text.clear()
        }
    }
}


