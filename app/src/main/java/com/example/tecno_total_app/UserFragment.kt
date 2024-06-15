package com.example.tecno_total_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class UserFragment : Fragment() {
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString("username")
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        // Find the TextView and set the username
        val textView = view.findViewById<TextView>(R.id.username_text_view)
        textView.text = username

        // Find the Button and set the click listener
        val logoutButton = view.findViewById<Button>(R.id.logout_button)
        logoutButton.setOnClickListener {
            // Start LoginActivity
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)

            // Close the current activity
            activity?.finish()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(username: String) =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString("username", username)
                }
            }
    }
}