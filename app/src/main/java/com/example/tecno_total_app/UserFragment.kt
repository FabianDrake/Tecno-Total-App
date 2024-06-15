package com.example.tecno_total_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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